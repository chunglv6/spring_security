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
@Document(collection = "context_link")

public class ContextLink implements Serializable {

    private static final long serialVersionUID = 2385262672722379520L;

    @NotNull
    private Footprint creator;

    @NotNull
    private Footprint lastUpdate;

    @NotNull
    private long version;

}
