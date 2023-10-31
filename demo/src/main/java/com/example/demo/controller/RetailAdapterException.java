package com.example.demo.controller;

public class RetailAdapterException extends RuntimeException {

    private static final long serialVersionUID = 4909363268209420745L;

    /**
     * Instantiates a new retail adapter exception.
     *
     * @param ex the ex
     */
    public RetailAdapterException(Exception ex) {
        super(ex);
    }

}
