package com.chintan.practice.urlinjection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UrlInjector {

    // private final static String serviceUrl = "http://ded4102.ded.reflected.net:8088/dmca/crawler-api/seed-injector/inject";
    private final static String serviceUrl = "http://localhost:8088/dmca/crawler-api/seed-injector/inject";
    private final static String inputFileLocation = "youjizz.txt";
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static int batchSize = 100;
    private final static int waitTime = 1000;

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        // Read URLS from file and add to the list.
        List<String> urlList = new ArrayList<>();
        List<SeedInjectionMessage> seedInjectionMessageList = new ArrayList<>();

        Files.lines(Paths.get(ClassLoader.getSystemResource(inputFileLocation).toURI())).forEach(urlList::add);

        urlList.forEach(System.out::println);

        seedInjectionMessageList = urlList.stream()
                .map(url -> new SeedInjectionMessage(url, true, true, null))
                .collect(Collectors.toList());

        List<SeedInjectionMessage> batchList = new ArrayList<>();

        // Get each 1000 records from list and call the url with json body
        for (int i = 0; i < seedInjectionMessageList.size(); i++) {
            batchList.add(seedInjectionMessageList.get(i));
            if (i % batchSize == 0 || i == seedInjectionMessageList.size() - 1) {
                Thread.sleep(waitTime);
                System.out.println("Offset: " + i);
                sendRequest(batchList, serviceUrl);
                batchList.clear();
            }
        }

    }

    private static void sendRequest(List<SeedInjectionMessage> list, String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            String payload = objectMapper.writeValueAsString(list);
            StringEntity entity = new StringEntity(payload);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            try (CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost)) {
                System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            httpClient.close();
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class SeedInjectionMessage implements Serializable {

    private static final long serialVersionUID = 437887636010642245L;

    /**
     * seed url
     */
    private String url;

    /**
     * if need to force inject
     */
    @JsonProperty("force_injection")
    private boolean forceInjection;

    @JsonProperty("phashing_priority")
    private boolean pHashingPriority;

    @JsonProperty("max_depth")
    private Integer maxDepth;

    /*public SeedInjectionMessage(String url, boolean forceInjection, boolean pHashingPriority) {
        this.url = url;
        this.forceInjection = forceInjection;
        this.pHashingPriority = pHashingPriority;
    }*/
}