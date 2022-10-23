package com.rahmah.busana.service.serviceimpl;

import com.rahmah.busana.entity.User;
import com.rahmah.busana.repository.UserRepository;
import com.rahmah.busana.service.UserService;
import com.rahmah.busana.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        verify(id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        verify(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        verify(id);
        userRepository.deleteById(id);
    }

    private void verify(Long id) {
        if(!userRepository.findById(id).isPresent()){
            String message = String.format("Resource %s with ID %s not found", "user", id);
            throw new DataNotFoundException(message);
        }
    }
}
