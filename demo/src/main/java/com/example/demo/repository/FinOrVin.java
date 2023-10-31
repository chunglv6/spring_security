package com.example.demo.repository;

import com.mysema.query.annotations.QueryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
@QueryEntity
@Document(collection = "finOrVin")
public class FinOrVin {
    @Id
    private String id;
    private String outletId;
    private String type;
    private List<String> finOrVin;
}
