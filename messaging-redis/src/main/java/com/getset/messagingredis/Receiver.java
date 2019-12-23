package com.getset.messagingredis;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CountDownLatch;

@Log4j2
@AllArgsConstructor
public class Receiver {

    private CountDownLatch countDownLatch;

    public void receiveMessage(String message) {
        log.info("Received message: " + message);
        countDownLatch.countDown();
    }
}
