package com.example.logindemo.service;

import com.example.logindemo.dao.UserDao;
import com.example.logindemo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.findUserByEmailAndPassword(email, password);
    }

    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }

    public boolean updateUser(User user) {
        if (userDao.existsById(user.getUserId())) {
            userDao.save(user);
            return true;
        }
        return false;
    }

    public User getUserById(long userId) {
        return userDao.findUserByUserId(userId);
    }
}
