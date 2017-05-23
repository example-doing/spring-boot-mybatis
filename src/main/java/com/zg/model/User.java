package com.zg.model;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return this.id + "," + this.name + "," + this.age;
    }
}
