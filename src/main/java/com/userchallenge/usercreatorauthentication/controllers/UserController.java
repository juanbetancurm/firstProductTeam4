package com.userchallenge.usercreatorauthentication.controllers;

import com.userchallenge.usercreatorauthentication.models.UserModel;
import com.userchallenge.usercreatorauthentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserModel saveUser(@Validated @RequestBody UserModel userModel){
        return userService.saveUser(userModel);
    }
}
