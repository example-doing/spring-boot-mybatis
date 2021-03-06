package com.zg.result;

public enum HttpCodeEnum {
    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    PARAMS_INVALID(800, "OK");

    HttpCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
