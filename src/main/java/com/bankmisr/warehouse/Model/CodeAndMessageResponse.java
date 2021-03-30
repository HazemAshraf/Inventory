package com.bankmisr.warehouse.Model;

import lombok.Data;

@Data
public class CodeAndMessageResponse {
    private int code;
    private String message;

    public CodeAndMessageResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
