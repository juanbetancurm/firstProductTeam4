package com.userchallenge.usercreatorauthentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/demo")
public class DemoContoller {

    @GetMapping("/hello")
    public ResponseEntity<String> HelloWorld(){
        return ResponseEntity.ok("Hello from secured entry");
    }
}
