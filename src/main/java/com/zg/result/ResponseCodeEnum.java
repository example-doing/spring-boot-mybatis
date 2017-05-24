package com.zg.result;

public enum ResponseCodeEnum {
    OK(200, "OK"),
    CREATED(201, "Created"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    PARAMES_INVALID(800, "OK");

    ResponseCodeEnum(int code, String message) {
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
