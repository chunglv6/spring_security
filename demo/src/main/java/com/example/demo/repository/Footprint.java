package com.example.demo.repository;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Validated
@Document(collection = "footprint")
public class Footprint implements Serializable {

    private static final long serialVersionUID = -5274266026798566910L;


    @NotNull
    private String system;


    @NotNull
    private String userId;


    @NotNull
    private String timestamp;
}