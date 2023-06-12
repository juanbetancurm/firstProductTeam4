package com.userchallenge.usercreatorauthentication.configuration;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String INVALID_NULL_FIELDS_MESSAGE = "Please fill in all required fields. Leaving them blank is not allowed.";
    public static final String INVALID_MAIL_MESSAGE = "The email you submitted is not a valid email.";
    public static final String INVALID_PASSWORD_MESSAGE = "The password must have at least 4 characters including both numbers and letters.";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String PASSWORDS_DONT_MATCH_MESSAGE = "The entered passwords do not match.";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";

}
