package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Department;
import com.bankmisr.warehouse.entity.SerialNumber;

import java.util.List;

public class GetSerialNumberListResponse {
    private int code;
    private String message;
    private List<SerialNumber> data;

    public GetSerialNumberListResponse(){}
    public GetSerialNumberListResponse(int code, String message, List<SerialNumber> data) {
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

    public List<SerialNumber> getData() {
        return data;
    }

    public void setData(List<SerialNumber> data) {
        this.data = data;
    }
}
