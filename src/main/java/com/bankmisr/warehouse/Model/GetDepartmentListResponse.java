package com.bankmisr.warehouse.Model;

import com.bankmisr.warehouse.entity.Department;
import com.bankmisr.warehouse.entity.Unit;

import java.util.List;

public class GetDepartmentListResponse {
    private int code;
    private String message;
    private List<Department> data;

    public GetDepartmentListResponse(){}
    public GetDepartmentListResponse(int code, String message, List<Department> data) {
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

    public List<Department> getData() {
        return data;
    }

    public void setData(List<Department> data) {
        this.data = data;
    }
}
