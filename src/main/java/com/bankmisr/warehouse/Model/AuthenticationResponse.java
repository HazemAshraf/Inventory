package com.bankmisr.warehouse.Model;

public class AuthenticationResponse {


    private final String jwt;
    private  String statusCode;
    private String message;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getValidationMessage() {
        return message;
    }

    public void setValidationMessage(String message) {
        this.message = message;
    }



    public AuthenticationResponse(String jwt,String username,String code,String message) {
        this.jwt = jwt;
        this.username = username;
        this.statusCode=code;
        this.message=message;
    }

    public String getJwt() {
        return jwt;
    }
}