package com.userchallenge.usercreatorauthentication.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {  // this is a DAO object implemented to avoid working directly with the User entity

    private String firstName;
    private String LastName;
    private String email;
    private String password;

}
