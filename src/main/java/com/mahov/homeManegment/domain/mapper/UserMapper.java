package com.mahov.homeManegment.domain.mapper;

import com.mahov.homeManegment.domain.models.User;
import com.mahov.homeManegment.domain.requestDto.userDto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    List<UserDto> toUserDtoList(List<User> users);
}
