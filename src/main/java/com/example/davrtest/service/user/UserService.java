package com.example.davrtest.service.user;

import com.example.davrtest.dto.UserStatusUpdateDto;
import com.example.davrtest.model.User;

public interface UserService {
    User store(User user);
    User findById(Long id);
    UserStatusUpdateDto update(Long id, User newUser);
}
