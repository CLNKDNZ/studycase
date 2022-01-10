package com.hpsiemlak.studycase.services;

import com.hpsiemlak.studycase.models.User;
import com.hpsiemlak.studycase.models.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public ResponseEntity<List<User>> getUserList();

    public ResponseEntity<User> saveUsername(UserRequest userRequest);

    public ResponseEntity deleteUser(String id);

    public ResponseEntity<User> getUserByUserName(String userName);

}

