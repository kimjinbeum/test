package com.pico.project.mapper;

import com.pico.project.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int getUserCount(UserDto userDto);
    UserDto getUser(UserDto userDto);
    int userCheck(String userId);
    String insUser(UserDto userDto);
}
