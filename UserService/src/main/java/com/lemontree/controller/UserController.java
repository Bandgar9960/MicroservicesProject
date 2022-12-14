package com.lemontree.controller;

import com.lemontree.constants.AppConstants;
import com.lemontree.dto.ApiResponse;
import com.lemontree.dto.UserDto;
import com.lemontree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user){
        return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId){
        return new ResponseEntity<>(this.userService.getSingleUser(userId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable Long userId){
        return new ResponseEntity<>(this.userService.updateUser(user,userId),HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.USER_DELETE,true),HttpStatus.OK);
    }

}
