package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Items;

import java.util.List;

public class GetListResponse {
    private int code;
    private String message;
    private List<Items> data;

    public  GetListResponse(){}
    public GetListResponse(int code, String message, List<Items> data) {
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

    public List<Items> getData() {
        return data;
    }

    public void setData(List<Items> data) {
        this.data = data;
    }
}
