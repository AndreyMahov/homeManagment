package com.mahov.homeManegment.controllers.impl;

import com.mahov.homeManegment.domain.models.User;
import com.mahov.homeManegment.domain.requestDto.userDto.UserDto;
import com.mahov.homeManegment.services.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserControllerImpl {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAll() {
        return userService.find();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") long id) {
        return userService.find(id);
    }

    @PostMapping
    public void create(UserDto userDto) {
        userService.create(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping
    public void delete(long id) {
        userService.delete(id);
    }
}
