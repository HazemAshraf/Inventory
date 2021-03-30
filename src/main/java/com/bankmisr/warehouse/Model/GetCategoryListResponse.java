package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Category;
import com.bankmisr.warehouse.entity.Department;

import java.util.List;

public class GetCategoryListResponse {
    private int code;
    private String message;
    private List<Category> data;

    public GetCategoryListResponse(){}
    public GetCategoryListResponse(int code, String message, List<Category> data) {
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

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }
}
