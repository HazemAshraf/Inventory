package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Description;
import com.bankmisr.warehouse.entity.ItemCode;

import java.util.List;

public class GetItemCodeListResponse {
    private int code;
    private String message;
    private List<ItemCode> data;

    public GetItemCodeListResponse(){}
    public GetItemCodeListResponse(int code, String message, List<ItemCode> data) {
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

    public List<ItemCode> getData() {
        return data;
    }

    public void setData(List<ItemCode> data) {
        this.data = data;
    }
}
