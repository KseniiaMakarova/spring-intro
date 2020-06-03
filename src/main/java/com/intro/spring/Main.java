package com.intro.spring;

import com.intro.spring.context.AppConfig;
import com.intro.spring.model.User;
import com.intro.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setName("John");
        user.setAge(39);
        userService.add(user);

        userService.listUsers().forEach(System.out::println);
    }
}
