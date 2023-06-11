package com.userchallenge.usercreatorauthentication.controllers;

import com.userchallenge.usercreatorauthentication.configuration.exceptions.MailAlreadyExistsException;
import com.userchallenge.usercreatorauthentication.models.UserModel;
import com.userchallenge.usercreatorauthentication.repositories.UserRepository;
import com.userchallenge.usercreatorauthentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public UserModel saveUser(@Validated @RequestBody UserModel userModel){
        if (userRepository.existsByMail(userModel.getMail())){
            throw new MailAlreadyExistsException();
        }
            return userService.saveUser(userModel);
    }
}
