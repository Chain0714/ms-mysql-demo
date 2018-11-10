package org.chain.mysqldemo.controller;

import org.chain.mysqldemo.entity.User;
import org.chain.mysqldemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User user(@PathVariable Long id) {
        return userMapper.findById(id);
    }
}
