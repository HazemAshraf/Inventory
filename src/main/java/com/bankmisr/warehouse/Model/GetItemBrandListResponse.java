package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Department;
import com.bankmisr.warehouse.entity.ItemBrand;

import java.util.List;

public class GetItemBrandListResponse {
    private int code;
    private String message;
    private List<ItemBrand> data;

    public GetItemBrandListResponse(){}
    public GetItemBrandListResponse(int code, String message, List<ItemBrand> data) {
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

    public List<ItemBrand> getData() {
        return data;
    }

    public void setData(List<ItemBrand> data) {
        this.data = data;
    }
}
