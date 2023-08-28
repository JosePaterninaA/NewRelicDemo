package com.example.newrelicdemo.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NetworkLatencyService {
    public void runThing() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5) + 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
