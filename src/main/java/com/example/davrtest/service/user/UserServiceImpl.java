package com.example.davrtest.service.user;

import com.example.davrtest.dto.UserStatusUpdateDto;
import com.example.davrtest.model.User;
import com.example.davrtest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User store(User user) {
        try {
            return userRepository.save(user);
        } catch (RuntimeException exception) {
            throw new RuntimeException("can't save");
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    @Override
    public UserStatusUpdateDto update(Long id, User newUser) {
        String previousStatus = findById(id).getStatus();
        userRepository.findById(id)
                .map(user -> {
                    user.setStatus(newUser.getStatus());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserStatusUpdateDto(id, previousStatus, newUser.getStatus());
    }
}
