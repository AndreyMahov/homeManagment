package com.mahov.homeManegment.services;

import com.mahov.homeManegment.domain.models.User;
import com.mahov.homeManegment.domain.requestDto.userDto.UserDto;

import java.util.List;

public interface UserService {
    List<User> find();

    User find(long id);

    void create(UserDto userDto);

    void update(long id, UserDto userDto);

    void delete(long id);

    boolean existsByLogin(String login);

    void save(User person);
}
