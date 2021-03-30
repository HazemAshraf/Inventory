package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Branch;
import com.bankmisr.warehouse.entity.Items;

import java.util.List;

public class GetBranchListResponse {
    private int code;
    private String message;
    private List<Branch> data;

    public GetBranchListResponse(){}
    public GetBranchListResponse(int code, String message, List<Branch> data) {
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

    public List<Branch> getData() {
        return data;
    }

    public void setData(List<Branch> data) {
        this.data = data;
    }
}
