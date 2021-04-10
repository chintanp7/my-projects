package com.example.actuatordemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


public class SingletonService {

    @Autowired
    PrototypeService prototypeService;

    public SingletonService() {
        System.out.println("Singleton service created");
    }

    public PrototypeService callPrototypeService() {
        System.out.println(LocalDateTime.now());
        return prototypeService;
    }
}
