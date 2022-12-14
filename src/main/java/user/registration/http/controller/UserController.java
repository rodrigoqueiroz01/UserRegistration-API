package user.registration.http.controller;

import user.registration.http.dto.request.LoginRequest;
import user.registration.http.dto.request.UserRequest;
import user.registration.http.dto.response.UserResponse;
import user.registration.http.mapper.UserMapper;
import user.registration.service.UserService;
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
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok()
                .body(userService.findByLoginAndPassword(loginRequest.getLogin(), loginRequest.getPassword()));
    }

}
