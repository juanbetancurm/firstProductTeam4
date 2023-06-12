package com.userchallenge.usercreatorauthentication.validation;

import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidMailException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidNullFieldsException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.InvalidPasswordException;
import com.userchallenge.usercreatorauthentication.configuration.exceptions.PasswordsDontMatchException;
import com.userchallenge.usercreatorauthentication.models.UserModel;

import java.util.regex.Pattern;

    /* This class is responsible for validating the data entered to save
    the user. It takes the model (userModel) and an instance of it as
    arguments and invokes various validation methods.
    */

public class UserValidation {
    public static void validateUserModel(UserModel userModel) {
        validateMandatoryFields(userModel);
        validateMail(userModel.getMail());
        validateFormatPassword(userModel.getPassword());
        validateCoincidentPasswords(userModel);
    }
    /* This method prevents any field from being sent without information.
    It ensures that values are not null, not empty, and not consisting only
    of whitespace characters.
    */
    private static void validateMandatoryFields(UserModel userModel) {
        if (userModel.getMail() == null || userModel.getMail().isEmpty() || userModel.getMail().isBlank() ||
                userModel.getPassword() == null || userModel.getPassword().isEmpty() || userModel.getPassword().isBlank() ||
                userModel.getPasswordConfirm() == null || userModel.getPasswordConfirm().isEmpty() || userModel.getPasswordConfirm().isBlank()) {
            throw new InvalidNullFieldsException();
        }
    }

    /* This method prevents the insertion of incorrectly formatted email addresses
     using regular expressions (Regex).
    */
    private static void validateMail(String mail) throws InvalidMailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        if (!Pattern.matches(emailRegex, mail)) {
            throw new InvalidMailException();
        }
    }
    /* This method enforces certain rules for password selection. The password must
     be at least 4 characters long and must contain both letters and numbers.
    */
    private static void validateFormatPassword(String password) throws InvalidPasswordException {
        String passwordRegex = "^[a-zA-Z0-9]{4,}$";
        if (!Pattern.matches(passwordRegex, password)) {
            throw new InvalidPasswordException();
        }
    }
    /* This method verifies if the password and the confirmation password match.
    */
    private static void validateCoincidentPasswords(UserModel userModel) {
        if ((!userModel.getPassword().equals(userModel.getPasswordConfirm()))) {
            throw new PasswordsDontMatchException();
        }
    }
}
