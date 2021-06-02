package org.example.service;

import org.example.controllers.Requester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


public class OrderRequester {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRequester.class);

    @Autowired
    private Requester requester;

    @PostConstruct
    public void pollRequester(){
        while(true) {
            String text = requester.getOrder();
            LOGGER.info("Order {}", text);
        }
    }
}
