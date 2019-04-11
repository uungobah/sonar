package com.nurul.akbar.akbarsonar.activemq;

import com.nurul.akbar.akbarsonar.solr.service.AuthorService;
import com.nurul.akbar.akbarsonar.solr.service.TwitterDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import java.util.concurrent.CountDownLatch;

public class Receiver extends Thread {
    @Autowired
    TwitterDataService twitterDataService;

    @Autowired
    AuthorService authorService;


    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "sonar")
    public void receive(String message) {

        Thread thread = new Thread(){
            public void run(){
                LOGGER.info("received message='{}'", message);
                twitterDataService.save(message);
                authorService.save(message);

            }
        };
        thread.start();

        latch.countDown();
    }

}
