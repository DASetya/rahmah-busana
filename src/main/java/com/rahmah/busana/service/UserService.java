package com.rahmah.busana.service;

import com.rahmah.busana.entity.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public User getUserById(Long id);
    public List<User> getAllUser();
    public User updateUser(User user);
    public void deleteUser(Long id);
}
