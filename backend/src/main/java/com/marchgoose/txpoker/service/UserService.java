package com.marchgoose.txpoker.service;

import com.marchgoose.txpoker.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author steeveen
 * @date 2024/11/2 16:25
 */
@Service
@Slf4j
public class UserService {
    private Map<String, User> userContainer = new HashMap<>();

    public List<User> list() {
        ArrayList<User> allUsers = new ArrayList<>();
        userContainer.forEach((id, user) -> allUsers.add(user));
        return allUsers;
    }

    public void login(User user) {
        userContainer.put(user.getUserId(), user);
    }
}
