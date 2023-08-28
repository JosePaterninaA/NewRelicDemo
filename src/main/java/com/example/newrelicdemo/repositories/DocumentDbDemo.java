package com.example.newrelicdemo.repositories;


import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "demo-collection")
@Builder
public class DocumentDbDemo {
    @Id
    private String id;
    private String demoInfo;
}
