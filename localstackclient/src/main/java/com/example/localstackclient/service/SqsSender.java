package com.example.localstackclient.service;

import com.example.localstackclient.model.UrlData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class SqsSender {

    private Logger log = LoggerFactory.getLogger(SqsSender.class);

    private final SqsAsyncClient sqsAsyncClient;

    @Value("${queue.name}")
    private String queueName;

    ObjectMapper objectMapper = new ObjectMapper();

    public SqsSender(SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    @PostConstruct
    public void sendMessage() throws ExecutionException, InterruptedException {
        log.info("Sending message...");
        CompletableFuture future = sqsAsyncClient.getQueueUrl(GetQueueUrlRequest.builder().queueName(queueName).build());
        GetQueueUrlResponse response = (GetQueueUrlResponse) future.get();

        Mono.fromFuture(() -> sqsAsyncClient.sendMessage(
                SendMessageRequest.builder()
                        .queueUrl(response.queueUrl())
                        .messageBody(createUrlData()).build()
        ))
                .retryWhen(Retry.max(3))
                .subscribe();
    }

    private String createUrlData() {
        UrlData urlData = new UrlData();
        urlData.setUrl("http://www.google.com");
        urlData.setDomain("google.com");
        urlData.setHttpStatus(200);
        urlData.setId(1);

        try {
            return objectMapper.writeValueAsString(urlData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
