package com.userchallenge.usercreatorauthentication.configuration;

import com.userchallenge.usercreatorauthentication.exceptions.InvalidMailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Collections;
import java.util.Map;

import static com.userchallenge.usercreatorauthentication.configuration.Constants.INVALID_MAIL_MESSAGE;
import static com.userchallenge.usercreatorauthentication.configuration.Constants.RESPONSE_ERROR_MESSAGE_KEY;

@ControllerAdvice
public class ControllerAdvisor {

        @ExceptionHandler(InvalidMailException.class)
        public ResponseEntity<Map<String, String>> handleInvalidMailException(
                InvalidMailException invalidMailException) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_MAIL_MESSAGE));
        }
}
