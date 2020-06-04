package com.intro.spring.controller;

import com.intro.spring.dto.UserResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "HelloMates";
    }

    @GetMapping("/userDto")
    @ResponseBody
    public UserResponseDto getUser() {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName("Kseniia");
        userResponseDto.setAge(24);
        return userResponseDto;
    }
}
