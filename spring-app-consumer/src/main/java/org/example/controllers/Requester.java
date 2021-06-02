package org.example.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Requester {
    private static final String URI = "http://localhost:8080/producer/get";

    public String getOrder(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URI, String.class);
    }
}
