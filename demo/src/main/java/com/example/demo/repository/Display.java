package com.example.demo.repository;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Display implements Serializable {

    private static final long serialVersionUID = 7264548245043533177L;

    private String customerFirstName;
    private String customerLastName;
    private String licensePlateNumber;
    private String finOrVin;
}
