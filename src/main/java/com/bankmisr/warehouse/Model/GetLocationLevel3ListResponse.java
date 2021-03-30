package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.LocationLevel2;
import com.bankmisr.warehouse.entity.LocationLevel3;

import java.util.List;

public class GetLocationLevel3ListResponse {
    private int code;
    private String message;
    private List<LocationLevel3> data;

    public GetLocationLevel3ListResponse(){}
    public GetLocationLevel3ListResponse(int code, String message, List<LocationLevel3> data) {
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

    public List<LocationLevel3> getData() {
        return data;
    }

    public void setData(List<LocationLevel3> data) {
        this.data = data;
    }
}
