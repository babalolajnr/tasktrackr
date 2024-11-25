package com.tasktrackr.tasktrackr.auth.user;

import com.tasktrackr.tasktrackr.auth.user.v1.dto.RegisterRequest;
import com.tasktrackr.tasktrackr.user.User;

public interface UserAuthService {
    User registerUser(RegisterRequest request);
}