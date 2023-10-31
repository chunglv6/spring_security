package com.example.demo.repository;


public enum ContextStatus {

    //@formatter:off
    SC_CREATION_FAILED("SC_Creation_Failed"),
    FAILED("Failed"),
    OK("Ok"),
    ARCHIVED("Archived"),
    CANCELED("Canceled");
    //@formatter:on

    private String value;

    ContextStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
