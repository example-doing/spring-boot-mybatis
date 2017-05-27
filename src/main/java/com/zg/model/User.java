package com.zg.model;


import com.zg.dto.UserDTO;
import com.zg.utils.StringUtils;

public class User {
    private int id;
    private String name;
    private int age;

    public static User fromUserDTO(UserDTO user) {
        return new User(user);
    }

    User(UserDTO user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return StringUtils.asStringPretty(this);
    }
}
