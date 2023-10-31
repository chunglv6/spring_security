package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinOrVinRepository extends MongoRepository<FinOrVin,String> {
    FinOrVin findByOutletId(String outletId);
}
