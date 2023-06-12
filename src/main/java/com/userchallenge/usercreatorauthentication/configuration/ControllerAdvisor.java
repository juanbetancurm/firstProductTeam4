package com.userchallenge.usercreatorauthentication.configuration;

import com.userchallenge.usercreatorauthentication.configuration.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Collections;
import java.util.Map;

import static com.userchallenge.usercreatorauthentication.configuration.Constants.*;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(InvalidMailException.class)
    public ResponseEntity<Map<String, String>> handleInvalidMailException(
                InvalidMailException invalidMailException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_MAIL_MESSAGE));
    }

    @ExceptionHandler(InvalidNullFieldsException.class)
    public ResponseEntity<Map<String, String>> handleInvalidNullFieldsException(
            InvalidNullFieldsException invalidNullFieldsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_NULL_FIELDS_MESSAGE));
    }

    @ExceptionHandler(MailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleMailAlreadyExistsException(
            MailAlreadyExistsException mailAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, MAIL_ALREADY_EXISTS_MESSAGE));
    }
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Map<String, String>> handleInvalidPasswordException(
            InvalidPasswordException invalidPasswordException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_PASSWORD_MESSAGE));
    }
    @ExceptionHandler(PasswordsDontMatchException.class)
    public ResponseEntity<Map<String, String>> handlePasswordsDontMatchException(
            PasswordsDontMatchException passwordsDontMatchException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PASSWORDS_DONT_MATCH_MESSAGE));
    }
}


