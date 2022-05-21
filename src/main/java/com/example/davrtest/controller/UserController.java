package com.example.davrtest.controller;

import com.example.davrtest.dto.UserDto;
import com.example.davrtest.dto.UserStatusUpdateDto;
import com.example.davrtest.model.User;
import com.example.davrtest.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    ResponseEntity<UserDto> store(@RequestBody User user) {
        return ResponseEntity.ok(new UserDto(userService.store(user)));
    }

    @GetMapping("{id}")
    ResponseEntity<UserDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(new UserDto(userService.findById(id)));
    }

    @PutMapping("{id}")
    ResponseEntity<UserStatusUpdateDto> edit(@RequestBody User newUser, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(id, newUser));
    }
}
