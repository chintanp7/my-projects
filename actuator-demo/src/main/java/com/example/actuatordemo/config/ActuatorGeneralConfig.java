package com.example.actuatordemo.config;

import com.example.actuatordemo.service.PrototypeService;
import com.example.actuatordemo.service.SingletonService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ActuatorGeneralConfig {
    @Bean
    public SingletonService singletonService() {
        return new SingletonService();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeService prototypeService() {
        return new PrototypeService();
    }
}
