package com.bankmisr.warehouse.Model;

public class PostListResponse {
    private int code;
    private String message;
    private String picture_id;
    private int item_id;

    public PostListResponse() {
    }

    public PostListResponse(int code, String message, String picture_id, int item_id) {
        this.code = code;
        this.message = message;
        this.picture_id = picture_id;
        this.item_id = item_id;
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

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
