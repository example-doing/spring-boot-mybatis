package com.zg.result;

public class HttpLog {
    private long beginTime;
    private long endTime;
    private String remoteIP;
    private String method;
    private String path;
    private String classMethod;
    private int code;

    public HttpLog(String remoteIP, String method, String path, String classMethod) {
        this.remoteIP = remoteIP;
        this.method = method;
        this.path = path;
        this.classMethod = classMethod;
        this.beginTime = System.currentTimeMillis();
    }

    public void setCode(int code) {
        this.code = code;
        this.endTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.code)
                .append(" ")
                .append(this.endTime - this.beginTime)
                .append("ms ")
                .append(this.method)
                .append(" ")
                .append(this.path)
                .append(" ")
                .append(this.classMethod);
        return sb.toString();
    }
}
