package com.example.demo.repository;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Validated
@Document(collection = "db_data")
public class DBData implements Serializable {

    private static final long serialVersionUID = -2105143900084053288L;


    private String technicalJobId;


    private String serviceJobId;

}