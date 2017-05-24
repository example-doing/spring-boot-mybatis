package com.zg.web.user;

import com.zg.dto.UserDTO;
import com.zg.model.User;
import com.zg.result.ResponseCodeEnum;
import com.zg.result.ResponseView;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{user_uuid}")
    @ResponseBody
    public ResponseView<UserDTO> GetUser(@PathVariable("user_uuid") String userUUID) {
        int id = Integer.parseInt(userUUID);
        User u = userService.findByID(id);
        ResponseView resp;
        if (u != null) {
            resp = new ResponseView<>(ResponseCodeEnum.OK, UserDTO.build(u));
        } else {
            resp = new ResponseView<>(ResponseCodeEnum.PARAMES_INVALID);
        }
        return resp;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public ResponseView<UserDTO> insertUser(@RequestBody UserDTO userDTO) {


        return null;
    }
}
