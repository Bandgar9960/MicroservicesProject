package com.lemontree.service;

import com.lemontree.dto.UserDto;

import java.util.List;

public interface UserService {


    UserDto saveUser(UserDto user);

    UserDto getSingleUser(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto user,Long userId);

    void deleteUser(Long userId);
}
