package com.zg.result;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "message", "result"})
public class ResponseView<T> {
    private final int code;
    private final String message;
    private T result;

    public ResponseView(ResponseCodeEnum code) {
        this(code, null);
    }

    public ResponseView(ResponseCodeEnum code, T result) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
