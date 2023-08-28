package com.example.newrelicdemo.repositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository
public class LongRunningQueryRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<WhateverEntity> finEntitiesWithLongRunningQuery() {
//        return entityManager.createQuery("SELECT e FROM WhateverEntity e", WhateverEntity.class)
//                .setHint("javax.persistence.query.timeout", 5000) // Set query timeout to 5 seconds
//                .getResultList();
//    }
}
