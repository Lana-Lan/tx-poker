package com.marchgoose.txpoker.controller;

import com.marchgoose.txpoker.entity.User;
import com.marchgoose.txpoker.service.UserService;
import com.marchgoose.txpoker.utils.BasicUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 登录Controller
 *
 * @author steeveen
 * @date 2024/11/2 16:25
 */
@Controller
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    @MessageMapping("/login")
    @SendTo("/topic/user-list")
    public List<User> handlePing(@RequestBody String userName) {
        User user = new User();
        user.setUserName(userName);
        user.setUserId(BasicUtils.uuid());
        userService.login(user);
        return userService.list();
    }
}
