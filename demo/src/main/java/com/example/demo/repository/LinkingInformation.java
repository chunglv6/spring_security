package com.example.demo.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Document(collection = "linking_information")
public class LinkingInformation implements Serializable {

    private static final long serialVersionUID = 5154205661062754890L;

    @NotNull
    private String key;

    @NotNull
    private String value;
}
