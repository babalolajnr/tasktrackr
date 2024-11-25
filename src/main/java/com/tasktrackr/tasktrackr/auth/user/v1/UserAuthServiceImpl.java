package com.tasktrackr.tasktrackr.auth.user.v1;

import org.springframework.stereotype.Service;

import com.tasktrackr.tasktrackr.auth.user.UserAuthService;
import com.tasktrackr.tasktrackr.auth.user.v1.dto.RegisterRequest;
import com.tasktrackr.tasktrackr.user.User;
import com.tasktrackr.tasktrackr.user.UserService;

import java.util.UUID;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final UserService userService;

    public UserAuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User registerUser(RegisterRequest request) {
        if (userService.isUsernameExists(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userService.isEmailExists(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        return userService.createUser(user);
    }
}