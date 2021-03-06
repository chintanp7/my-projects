package com.example.logindemo.dao;

import com.example.logindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    public User findUserByEmailAndPassword(String email, String password);

    public User findUserByUserId(long userId);
}
