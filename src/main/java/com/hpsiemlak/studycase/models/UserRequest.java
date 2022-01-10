package com.hpsiemlak.studycase.models;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String role;
}


