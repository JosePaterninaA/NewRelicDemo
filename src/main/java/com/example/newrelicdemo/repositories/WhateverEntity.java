package com.example.newrelicdemo.repositories;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WhateverEntity {
    @Id
    private Long id;
    private String demoInfo;
}
