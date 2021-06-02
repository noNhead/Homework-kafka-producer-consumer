package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderResponder {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderResponder.class);
    private static final int TIME_SLEEP = 3000;
    private static final int LEFT_CHAR_LIMIT = 97;
    private static final int RIGHT_CHAR_LIMIT = 122;
    private static final int TARGET_STRING_LENGTH = 10;
    private static final String ORDERS_404 = "Orders not found";
    private final List<String> orders = new ArrayList<>();


    public void orderGenerator() {
        final Runnable thread = () -> {
            while (true) {
                orders.add(randomStringGenerator());
                LOGGER.info("Was added order: {}", orders.get(orders.size()-1));
                try {
                    Thread.sleep(TIME_SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        };

        thread.run();
    }

    public String randomStringGenerator(){
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(TARGET_STRING_LENGTH);
        for (int i = 0; i < TARGET_STRING_LENGTH; i++) {
            int randomLimitedInt = LEFT_CHAR_LIMIT + (int)
                    (random.nextFloat() * (RIGHT_CHAR_LIMIT - LEFT_CHAR_LIMIT + 1));
            buffer.append(randomLimitedInt);
        }
        return buffer.toString();
    }
    public String getFirstElementPopup(){
        if (orders.isEmpty()) {
            return ORDERS_404;
        }
        String string = this.orders.get(0);
        orders.remove(0);
        return string;
    }
}
