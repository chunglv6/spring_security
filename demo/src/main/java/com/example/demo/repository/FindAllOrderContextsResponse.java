package com.example.demo.repository;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class FindAllOrderContextsResponse {

    private List<Context> contexts;
    private long totalNrOfElements;
    private int totalNrOfPages;
    private long nrOfOrderContexts;
    private long nrOfMyOrderContexts;
    private long nrOfOrderContextsWithError;
}

