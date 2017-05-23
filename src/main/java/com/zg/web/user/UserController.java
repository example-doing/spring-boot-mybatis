package com.zg.web.user;

import com.zg.model.User;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{user_uuid}")
    public String GetUser(@PathVariable("user_uuid") String userUUID) {
        int id = Integer.parseInt(userUUID);
        User u = userService.findByID(id);
        return "hello :" + u.toString();
    }
}
