package com.chintan.practice.url;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlTest {

    public static void main(String[] args) throws URISyntaxException {
        String url = "https://noodlemagazine.com/watch/-123400772_456253461";
        URI uri = new URI(url);
        System.out.println(uri.getHost());
    }
}
