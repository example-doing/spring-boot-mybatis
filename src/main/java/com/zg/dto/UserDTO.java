package com.zg.dto;


import com.zg.model.User;
import com.zg.utils.StringUtils;

public class UserDTO {
    private int id;
    private String name;
    private int age;

    public static UserDTO fromUser(User user) {
        return new UserDTO(user);
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public UserDTO() {
    }

    public User toUser() {
        return User.fromUserDTO(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return StringUtils.asStringPretty(this);
    }
}
