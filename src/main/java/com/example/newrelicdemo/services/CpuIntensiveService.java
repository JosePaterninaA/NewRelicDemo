package com.example.newrelicdemo.services;

import org.springframework.stereotype.Service;

@Service
public class CpuIntensiveService
{
    public double runThing(){
        final int numberOfIterations = 1_000_000_000;
        double result = 0.0;

        for (int i = 0; i < numberOfIterations; i++) {
            result += Math.sqrt(i + Math.random());
        }

        return result;
    }
}
