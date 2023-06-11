package com.userchallenge.usercreatorauthentication.validation;

import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidMailException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidNullFieldsException;
import com.userchallenge.usercreatorauthentication.models.UserModel;

import java.util.regex.Pattern;


public class UserValidation {
    public static void validateUserModel(UserModel userModel) {
        validateMandatoryFields(userModel);
        validateMail(userModel.getMail());
        //validatePassword(userModel.getPassword());
    }


    private static void validateMandatoryFields(UserModel userModel) {
        if (userModel.getMail() == null || userModel.getMail().isEmpty() || userModel.getMail().isBlank() ||
                userModel.getPassword() == null || userModel.getPassword().isEmpty() || userModel.getPassword().isBlank()) {
            throw new InvalidNullFieldsException();
        }
    }
    private static void validateMail(String mail) throws InvalidMailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]+$";
        if (!Pattern.matches(emailRegex, mail)) {
            throw new InvalidMailException();
        }
    }
}
