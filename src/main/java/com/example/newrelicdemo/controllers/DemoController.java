package com.example.newrelicdemo.controllers;

import com.example.newrelicdemo.newrelic.customevents.CPUInformation;
import com.example.newrelicdemo.repositories.DemoRepository;
import com.example.newrelicdemo.repositories.DocumentDbDemo;
import com.example.newrelicdemo.services.CpuIntensiveService;
import com.example.newrelicdemo.services.LongRunningQueryService;
import com.example.newrelicdemo.services.MemoryLeakService;
import com.example.newrelicdemo.services.NetworkLatencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/demo")
@Slf4j
public class DemoController {

    private final CpuIntensiveService cpuIntensiveService;
    private final LongRunningQueryService longRunningQueryService;
    private final MemoryLeakService memoryLeakService;
    private final NetworkLatencyService networkLatencyService;

    private final DemoRepository demoRepository;

    public DemoController(CpuIntensiveService cpuIntensiveService, LongRunningQueryService longRunningQueryService, MemoryLeakService memoryLeakService, NetworkLatencyService networkLatencyService, DemoRepository demoRepository) {
        this.cpuIntensiveService = cpuIntensiveService;
        this.longRunningQueryService = longRunningQueryService;
        this.memoryLeakService = memoryLeakService;
        this.networkLatencyService = networkLatencyService;
        this.demoRepository = demoRepository;
    }

    @GetMapping()
    public ResponseEntity<String> demo(@RequestHeader HttpHeaders headers){

        log.info("Request received from host {}", headers.getHost());
        CPUInformation event = new CPUInformation();
        event.startTime = new Date().getTime();
        event.cpu = "main";
        event.description = "Custom event";
        event.sockets = 1;
        event.cores = 4;
        event.hwThreads = 2;
        event.commit();
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/test")
    public ResponseEntity<String> baseTest(@RequestHeader HttpHeaders headers){
        demoRepository.insert(DocumentDbDemo.builder().demoInfo("Demo data").build());
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/test1")
    public ResponseEntity<String> test1(@RequestHeader HttpHeaders headers){
        cpuIntensiveService.runThing();
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2(@RequestHeader HttpHeaders headers){
//        longRunningQueryService.runThing();
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/test3")
    public ResponseEntity<String> test3(@RequestHeader HttpHeaders headers){
        memoryLeakService.runThing();
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/test4")
    public ResponseEntity<String> test4(@RequestHeader HttpHeaders headers){
        networkLatencyService.runThing();
        return ResponseEntity.ok("Ok");
    }
}
