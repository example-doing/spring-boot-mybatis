package com.zg.dto;


import com.zg.model.User;

public class UserDTO {
    private int id;
    private String name;
    private int age;

    public static UserDTO build(User user) {
        return new UserDTO(user);
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
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
}
