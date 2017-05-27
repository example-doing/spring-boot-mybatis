package com.zg.result;

class HttpLog {
    private final long beginTime;
    private final String ip;
    private final String method;
    private final String path;
    private final String classMethod;
    private long endTime;
    private int code;

    HttpLog(String ip, String method, String path, String classMethod) {
        this.ip = ip;
        this.method = method;
        this.path = path;
        this.classMethod = classMethod;
        this.beginTime = System.currentTimeMillis();
    }

    void setCode(int code) {
        this.code = code;
        this.endTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.method)
                .append(" ")
                .append(this.code)
                .append(" ")
                .append(this.endTime - this.beginTime)
                .append("ms ")
                .append(this.ip)
                .append(" ")
                .append(this.path)
                .append(" ")
                .append(this.classMethod);
        return sb.toString();
    }
}
