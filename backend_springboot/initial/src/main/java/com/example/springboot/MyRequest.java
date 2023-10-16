package com.example.springboot;

public class MyRequest {
    private String message;

    public MyRequest() {
    }

    public MyRequest(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }

    public void setValue(String message) {
        this.message = message;
    }
}
