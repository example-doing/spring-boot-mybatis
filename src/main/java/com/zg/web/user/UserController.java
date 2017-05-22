package com.zg.web.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user/{user_uuid}")
    public String GetUser(@PathVariable("user_uuid") String userUUID) {
        return "hello :" + userUUID;
    }
}
