package com.intro.spring.controller;

import com.intro.spring.dto.UserResponseDto;
import com.intro.spring.model.User;
import com.intro.spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectUsers() {
        User mary = new User();
        mary.setName("Mary");
        mary.setAge(18);
        userService.add(mary);
        User frederik = new User();
        frederik.setName("Frederik");
        frederik.setAge(25);
        userService.add(frederik);
        User josh = new User();
        josh.setName("Josh");
        josh.setAge(33);
        userService.add(josh);
        User lily = new User();
        lily.setName("Lily");
        lily.setAge(60);
        userService.add(lily);
        return "Injection was successful!";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return getUserResponseDtoFromUser(user);
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map((this::getUserResponseDtoFromUser))
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserResponseDtoFromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        return userResponseDto;
    }
}
