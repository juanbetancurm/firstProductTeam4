package com.userchallenge.usercreatorauthentication.validation;

import com.userchallenge.usercreatorauthentication.exceptions.InvalidMailException;
import com.userchallenge.usercreatorauthentication.models.UserModel;

import java.util.regex.Pattern;

public class UserValidation {

    public static void validateUserModel(UserModel userModel) {
        validateMail(userModel.getMail());
        //validatePassword(userModel.getPassword());
    }


    private static void validateMail(String mail) throws InvalidMailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(emailRegex, mail)) {
            throw new InvalidMailException();
        }
    }
}
