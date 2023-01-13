package com.mahov.homeManegment.services.impl;

import com.mahov.homeManegment.domain.mapper.UserMapper;
import com.mahov.homeManegment.domain.models.User;
import com.mahov.homeManegment.domain.requestDto.userDto.UserDto;
import com.mahov.homeManegment.repositories.UserRepository;
import com.mahov.homeManegment.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> find() {
        return userRepository.findAll();
    }

    @Override
    public User find(long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void create(UserDto userDto) {
        userRepository.save(userMapper.toUser(userDto));
    }

    @Override
    public void update(long id, UserDto userDto) {

    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
