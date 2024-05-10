package com.example.StudentManagement.common;

public class Result {
    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";

    private String message;
    private String code;
    private Object data;

    public static Result success(){
        Result resultOfRequest = new Result();
        resultOfRequest.setCode(SUCCESS);
        return resultOfRequest;
    }

    public static Result success(Object data){
        Result resultOfRequest = new Result();
        resultOfRequest.setCode(SUCCESS);
        resultOfRequest.setData(data);
        return resultOfRequest;
    }

    public static Result error(String message){
        Result resultOfRequest = new Result();
        resultOfRequest.setCode(ERROR);
        resultOfRequest.setMessage(message);
        return resultOfRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
