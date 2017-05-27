package com.zg.result;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "message", "result"})
public class ResponseView<T> {
    private int code;
    private String message;
    private T result;

    public ResponseView(HttpCodeEnum code) {
        this(code, null);
    }

    public ResponseView(HttpCodeEnum code, T result) {
        this.result = result;
        if (code != null) {
            this.code = code.getCode();
            this.message = code.getMessage();
        }
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }
}
