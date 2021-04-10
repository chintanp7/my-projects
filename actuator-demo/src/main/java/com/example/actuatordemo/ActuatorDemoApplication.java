package com.example.actuatordemo;

import com.example.actuatordemo.config.ActuatorGeneralConfig;
import com.example.actuatordemo.service.PrototypeService;
import com.example.actuatordemo.service.SingletonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ActuatorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorDemoApplication.class, args);
	}

	@PostConstruct
	public void testBeans() {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(ActuatorGeneralConfig.class);

		SingletonService firstSingleton = context.getBean(SingletonService.class);
		PrototypeService firstPrototype = firstSingleton.callPrototypeService();

		// get singleton bean instance one more time
		SingletonService secondSingleton = context.getBean(SingletonService.class);
		PrototypeService secondPrototype = secondSingleton.callPrototypeService();

		if (firstPrototype.equals(secondPrototype)) {
			System.out.println("Same");
		} else {
			System.out.println("Not Same");
		}
	}
}
