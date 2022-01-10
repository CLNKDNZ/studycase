package com.hpsiemlak.studycase.services;


import com.hpsiemlak.studycase.models.User;
import com.hpsiemlak.studycase.models.UserRequest;
import com.hpsiemlak.studycase.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<List<User>> getUserList() {
        var userlist = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userlist);
    }

    @Override
    public ResponseEntity saveUsername(UserRequest userRequest) {
        User user = bindUser(userRequest);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }


    @Override
    public ResponseEntity deleteUser(String id) {
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity<User> getUserByUserName(String userName) {
        var user = userRepository.findByUsername(userName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    private final User bindUser(UserRequest userRequest) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(userRequest.getPassword());
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(userRequest.getRole());
        return user;
    }


}
