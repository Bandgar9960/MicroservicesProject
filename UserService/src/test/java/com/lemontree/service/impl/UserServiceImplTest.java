package com.lemontree.service.impl;

import com.lemontree.repository.UserRepository;
import com.lemontree.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Autowired
   // @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void saveUser() {
    }

    @Test
    void getSingleUser() {
    }

    @Test
    void getAllUser() {

    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}