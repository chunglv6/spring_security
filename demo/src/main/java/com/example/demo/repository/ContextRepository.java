package com.example.demo.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextRepository extends MongoRepository<Context, String> {
    //'header.outletId': 'GS0001223','type': 'ORDER_CONTEXT'
    @Aggregation(pipeline = {"{$search: {'index': 'default','compound': {'must':[{'text':{'path':'header.outletId','query': '?0'}},{'text':{'path':'type','query': '?1'}},{'regex':{'allowAnalyzedField': true,'path':['display.customerLastName','display.customerFirstName','display.licensePlateNumber','display.finOrVin','contextMetaData.status','header.orderId'],'query': '(.*)?2(.*)'}}]}}}","?4", "{$limit: ?3}"})
    List<Context>  findByHeaderOutletIdAndType(String outletId,String type,String regex, int limit,String sort);

    @Aggregation(pipeline = {"?0","?1","?2","?3","?4"})
    FindAllOrderContextsResponse countAllPrams(String facet,String unwind1, String unwind2, String unwind3, String project);

    @Aggregation(pipeline = {"?0","?1","?2","?3","?4"})
    FindAllOrderContextsResponse findByPage(String search,String match,String sort,String facet, String addFields);

}
