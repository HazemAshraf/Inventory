package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.ItemBrand;
import com.bankmisr.warehouse.entity.ItemModel;

import java.util.List;

public class GetItemModelListResponse {
    private int code;
    private String message;
    private List<ItemModel> data;

    public GetItemModelListResponse(){}
    public GetItemModelListResponse(int code, String message, List<ItemModel> data) {
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

    public List<ItemModel> getData() {
        return data;
    }

    public void setData(List<ItemModel> data) {
        this.data = data;
    }
}
