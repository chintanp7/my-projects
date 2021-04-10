package com.example.actuatordemo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


public class PrototypeService {

    public void printTime() {
        System.out.println(LocalDateTime.now());
    }
}
