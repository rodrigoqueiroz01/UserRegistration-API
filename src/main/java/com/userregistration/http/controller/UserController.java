package com.userregistration.http.controller;

import com.userregistration.http.dto.request.UserRequest;
import com.userregistration.http.dto.response.UserResponse;
import com.userregistration.http.mapper.UserMapper;
import com.userregistration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok()
                .body(UserMapper.toResponse(userService.registerUser(UserMapper.toModel(userRequest))));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestParam(value = "login", required = true) String login,
                                              @RequestParam(value = "password", required = true) String password) {
        return ResponseEntity.ok()
                .body(userService.findByLoginAndPassword(login, password));
    }

}
