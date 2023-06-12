package com.userchallenge.usercreatorauthentication.validation;

import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidMailException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidNullFieldsException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidPasswordException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.PasswordsDontMatchException;
import com.userchallenge.usercreatorauthentication.models.UserModel;

import java.util.regex.Pattern;


public class UserValidation {
    public static void validateUserModel(UserModel userModel) {
        validateMandatoryFields(userModel);
        validateMail(userModel.getMail());
        validateFormatPassword(userModel.getPassword());
        validateCoincidentPasswords(userModel);
    }
    private static void validateMandatoryFields(UserModel userModel) {
        if (userModel.getMail() == null || userModel.getMail().isEmpty() || userModel.getMail().isBlank() ||
                userModel.getPassword() == null || userModel.getPassword().isEmpty() || userModel.getPassword().isBlank() ||
                userModel.getPasswordConfirm() == null || userModel.getPasswordConfirm().isEmpty() || userModel.getPasswordConfirm().isBlank()) {
            throw new InvalidNullFieldsException();
        }
    }
    private static void validateMail(String mail) throws InvalidMailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        if (!Pattern.matches(emailRegex, mail)) {
            throw new InvalidMailException();
        }
    }
    private static void validateFormatPassword(String password) throws InvalidPasswordException {
        String passwordRegex = "^[a-zA-Z0-9]{4,}$";
        if (!Pattern.matches(passwordRegex, password)) {
            throw new InvalidPasswordException();
        }
    }
    private static void validateCoincidentPasswords(UserModel userModel) {
        if ((!userModel.getPassword().equals(userModel.getPasswordConfirm()))) {
            throw new PasswordsDontMatchException();
        }
    }
}
