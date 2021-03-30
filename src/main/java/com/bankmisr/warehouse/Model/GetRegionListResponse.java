package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Branch;
import com.bankmisr.warehouse.entity.Region;

import java.util.List;

public class GetRegionListResponse {
    private int code;
    private String message;
    private List<Region> data;

    public GetRegionListResponse(){}
    public GetRegionListResponse(int code, String message, List<Region> data) {
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

    public List<Region> getData() {
        return data;
    }

    public void setData(List<Region> data) {
        this.data = data;
    }
}
