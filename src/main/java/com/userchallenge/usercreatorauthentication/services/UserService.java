package com.userchallenge.usercreatorauthentication.services;

import com.userchallenge.usercreatorauthentication.models.UserModel;
import com.userchallenge.usercreatorauthentication.repositories.UserRepository;
import com.userchallenge.usercreatorauthentication.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserModel saveUser(UserModel userModel){
        UserValidation.validateUserModel(userModel);
        return userRepository.save(userModel);
    }
}
