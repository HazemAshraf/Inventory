package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.LocationLevel1;
import com.bankmisr.warehouse.entity.LocationLevel2;

import java.util.List;

public class GetLocationLevel2ListResponse {
    private int code;
    private String message;
    private List<LocationLevel2> data;

    public GetLocationLevel2ListResponse(){}
    public GetLocationLevel2ListResponse(int code, String message, List<LocationLevel2> data) {
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

    public List<LocationLevel2> getData() {
        return data;
    }

    public void setData(List<LocationLevel2> data) {
        this.data = data;
    }
}
