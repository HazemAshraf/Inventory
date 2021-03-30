package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Department;
import com.bankmisr.warehouse.entity.ItemTypes;

import java.util.List;

public class GetItemTypesListResponse {
    private int code;
    private String message;
    private List<ItemTypes> data;

    public GetItemTypesListResponse(){}
    public GetItemTypesListResponse(int code, String message, List<ItemTypes> data) {
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

    public List<ItemTypes> getData() {
        return data;
    }

    public void setData(List<ItemTypes> data) {
        this.data = data;
    }
}
