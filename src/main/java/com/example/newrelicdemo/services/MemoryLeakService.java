package com.example.newrelicdemo.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryLeakService {
    public void runThing(){
        List<Integer> dataList = new ArrayList<>();
        while(true){
            for (int i = 0; i < 100_000; i++) {
                dataList.add(1);
            }

            dataList.remove(0);
        }
    }
}
