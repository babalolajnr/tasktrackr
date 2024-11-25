package com.tasktrackr.tasktrackr.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(String id);

    boolean isUsernameExists(String username);

    boolean isEmailExists(String email);
}