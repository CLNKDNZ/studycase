package com.hpsiemlak.studycase.resources;


import com.hpsiemlak.studycase.models.User;
import com.hpsiemlak.studycase.models.UserRequest;
import com.hpsiemlak.studycase.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserResources {

    private final UserService userService;

    @CrossOrigin(value = "*")
    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<User>> getUserList() {
        return userService.getUserList();

    }

    @CrossOrigin(value = "*")
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest) {

        return userService.saveUsername(userRequest);
    }

    @CrossOrigin(value = "*")
    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser() {

        return null;
    }

    @CrossOrigin(value = "*")
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathParam("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
