package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Region;
import com.bankmisr.warehouse.entity.Unit;

import java.util.List;

public class GetUnitListResponse {
    private int code;
    private String message;
    private List<Unit> data;

    public GetUnitListResponse(){}
    public GetUnitListResponse(int code, String message, List<Unit> data) {
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

    public List<Unit> getData() {
        return data;
    }

    public void setData(List<Unit> data) {
        this.data = data;
    }
}
