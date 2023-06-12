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

    /* This is the section for handling the logic. Currently, we only save users,
     so we have the saveUser method that invokes field validation. The logic for
     this validation is located in the validation class (UserValidation). After the
     validation, the saveUser method calls the save method from the JPA repository
     as a generic operation.
     */

    public UserModel saveUser(UserModel userModel){
        UserValidation.validateUserModel(userModel);
        return userRepository.save(userModel);
    }
}
