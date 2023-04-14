package com.lemontree.controller;

import com.lemontree.constants.AppConstants;
import com.lemontree.dto.ApiResponse;
import com.lemontree.dto.UserDto;
import com.lemontree.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
    }

    int retryCount = 1;

    @GetMapping("/{userId}")
    // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId) {
        log.info("retryCount : {}", retryCount);
        retryCount++;
        return new ResponseEntity<>(this.userService.getSingleUser(userId), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> ratingHotelFallback(Long userId, Exception ex) {
        log.info("Fallback is executed because service is down : " + ex.getMessage());

        UserDto user = UserDto.builder()
                .name("Dummy")
                .userId(12134545L)
                .active(true)
                .about("This user is created dummy because some service is down")
                .email("dummy@gmail.com")
                .build();

        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable Long userId) {
        return new ResponseEntity<>(this.userService.updateUser(user, userId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.USER_DELETE, true), HttpStatus.OK);
    }

}
