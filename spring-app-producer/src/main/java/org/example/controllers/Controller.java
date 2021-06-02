package org.example.controllers;

import org.example.service.OrderResponder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private OrderResponder orderResponder;

    @RequestMapping("/get")
    public String getRandomGeneratedString(){
        String order = orderResponder.getFirstElementPopup();
        LOGGER.info("Order request; The requested item has been sent: {}", order);
        return order;
    }
}
