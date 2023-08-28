package com.example.newrelicdemo;

import com.amazonaws.services.docdb.AmazonDocDB;
import com.amazonaws.services.docdb.AmazonDocDBClientBuilder;
import com.amazonaws.services.docdb.model.CreateDBInstanceRequest;
import com.amazonaws.services.opensearchserverless.model.CreateCollectionRequest;
import com.example.newrelicdemo.newrelic.customevents.CPUInformation;
import jdk.jfr.FlightRecorder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class NewRelicDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewRelicDemoApplication.class, args);

		FlightRecorder.register(CPUInformation.class);
	}

}
