package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.ItemCode;
import com.bankmisr.warehouse.entity.LocationLevel1;

import java.util.List;

public class GetLocationLevel1ListResponse {
    private int code;
    private String message;
    private List<LocationLevel1> data;

    public GetLocationLevel1ListResponse(){}
    public GetLocationLevel1ListResponse(int code, String message, List<LocationLevel1> data) {
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

    public List<LocationLevel1> getData() {
        return data;
    }

    public void setData(List<LocationLevel1> data) {
        this.data = data;
    }
}
