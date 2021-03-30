package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Department;
import com.bankmisr.warehouse.entity.Description;

import java.util.List;

public class GetDescriptionListResponse {
    private int code;
    private String message;
    private List<Description> data;

    public GetDescriptionListResponse(){}
    public GetDescriptionListResponse(int code, String message, List<Description> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Description> getData() {
        return data;
    }

    public void setData(List<Description> data) {
        this.data = data;
    }
}
