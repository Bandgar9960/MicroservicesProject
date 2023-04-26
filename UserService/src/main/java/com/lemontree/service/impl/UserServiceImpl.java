package com.lemontree.service.impl;

import com.lemontree.constants.AppConstants;
import com.lemontree.dto.Rating;
import com.lemontree.dto.UserDto;
import com.lemontree.exception.ResourceNotFoundException;
import com.lemontree.externalservice.HotelService;
import com.lemontree.model.Hotel;
import com.lemontree.model.User;
import com.lemontree.repository.UserRepository;
import com.lemontree.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public UserDto saveUser(UserDto user) {
        User user1 = this.modelMapper.map(user, User.class);
        User saveUser = this.userRepository.save(user1);
        return this.modelMapper.map(saveUser, UserDto.class);
    }

    @Override
    public UserDto getSingleUser(Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + userId));
        //http://localhost:8083/ratings/users/1
        Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        List<Rating> ratingList = Arrays.stream(ratings).toList();

        List<Rating> ratingsList = ratingList.stream().map((rating) -> {
            //http://localhost:8082/hotels/2
            // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            //  Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingsList);

        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUsers = this.userRepository.findAll();
        return allUsers.stream().map((users) -> this.modelMapper.map(users, UserDto.class)).toList();
    }

    @Override
    public UserDto updateUser(UserDto user, Long userId) {
        User users = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + userId));
        users.setName(user.getName());
        users.setEmail(user.getEmail());
        users.setAbout(user.getAbout());

        User saveUser = this.userRepository.save(users);
        return this.modelMapper.map(saveUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + userId));
        this.userRepository.delete(user);
    }
}
