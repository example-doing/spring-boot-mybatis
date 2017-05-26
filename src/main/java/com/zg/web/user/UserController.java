package com.zg.web.user;

import com.zg.dto.UserDTO;
import com.zg.model.User;
import com.zg.result.HttpCodeEnum;
import com.zg.result.ResponseView;
import com.zg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userUUID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseView<UserDTO> GetUser(@PathVariable("userUUID") String userUUID) {
        int id = Integer.parseInt(userUUID);
        User u = userService.findByID(id);
        ResponseView<UserDTO> resp;
        if (u != null) {
            resp = new ResponseView<>(HttpCodeEnum.OK);
            resp.setResult(UserDTO.fromUser(u));
        } else {
            resp = new ResponseView<>(HttpCodeEnum.PARAMS_INVALID);
        }
        return resp;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseView<List<UserDTO>> listUser() {
        List<User> users = userService.list();

        List<UserDTO> result = new ArrayList<>(users.size());
        for (User user : users) {
            result.add(UserDTO.fromUser(user));
        }

        return new ResponseView<List<UserDTO>>(HttpCodeEnum.OK, result);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseView<UserDTO> insertUser(@RequestBody UserDTO userDTO) {
        logger.info(userDTO.toString());
        User user = userDTO.toUser();
        int ret = userService.insert(user);
        userDTO.setId(ret);
        return new ResponseView<>(HttpCodeEnum.OK, userDTO);
    }

    @RequestMapping(value = "/user/{userUUID}/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseView<UserDTO> updateUser(@PathVariable("userUUID") int userUUID, @RequestBody UserDTO userDTO) {
        userDTO.setId(userUUID);
        User user = userDTO.toUser();

        int ret = userService.update(user);
        if (ret == 1) {
            return new ResponseView<>(HttpCodeEnum.OK, userDTO);
        } else {
            return new ResponseView<>(HttpCodeEnum.PARAMS_INVALID);
        }
    }

    @RequestMapping(value = "/user/{userUUID}/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseView<Integer> deleteUser(@PathVariable("userUUID") int userUUID) {
        int ret = userService.delete(userUUID);
        return new ResponseView<>(HttpCodeEnum.OK, ret);
    }
}
