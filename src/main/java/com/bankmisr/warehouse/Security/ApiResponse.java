/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankmisr.warehouse.Security;

/**
 *
 * @author AhmedElsayed
 */
public class ApiResponse {

	private int status;
	private String message;
	private Object result;

	public ApiResponse(int status, String message, Object result){
	    this.status = status;
	    this.message = message;
	    this.result = result;
    }

    public ApiResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    public ApiResponse(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message +"]";
	}


}