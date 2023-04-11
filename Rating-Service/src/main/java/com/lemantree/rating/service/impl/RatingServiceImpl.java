package com.lemantree.rating.service.impl;

import com.lemantree.rating.constants.AppConstants;
import com.lemantree.rating.dto.RatingDto;
import com.lemantree.rating.exception.ResourceNotFoundException;
import com.lemantree.rating.model.Rating;
import com.lemantree.rating.repository.RatingRepository;
import com.lemantree.rating.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

   
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDto saveRatings(RatingDto rating) {
        Rating rating1 = this.modelMapper.map(rating, Rating.class);
        Rating saveRatings = this.ratingRepository.save(rating1);
        return this.modelMapper.map(saveRatings, RatingDto.class);
    }

    @Override
    public RatingDto getSingleRating(Long ratingId) {
        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + ratingId));
        return this.modelMapper.map(rating,RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllRatings() {
        List<Rating> allRatings = this.ratingRepository.findAll();
        return allRatings.stream().map((ratings)-> this.modelMapper.map(ratings,RatingDto.class)).toList();
    }

    @Override
    public List<RatingDto> getAllRatingsByUserId(Long userId) {
        List<Rating> allRatings = this.ratingRepository.findByUserId(userId);
        return allRatings.stream().map((ratings)-> this.modelMapper.map(ratings,RatingDto.class)).toList();
    }

    @Override
    public List<RatingDto> getAllRatingsByHotelId(Long hotelId) {
        List<Rating> allRatings = this.ratingRepository.findByHotelId(hotelId);
        return allRatings.stream().map((ratings)-> this.modelMapper.map(ratings,RatingDto.class)).toList();
    }

    @Override
    public RatingDto updateRatings(RatingDto rating, Long ratingId) {
        Rating ratings = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + ratingId));
        ratings.setRating(rating.getRating());
        ratings.setFeedback(rating.getFeedback());

        Rating updatedRatings = this.ratingRepository.save(ratings);
        return this.modelMapper.map(updatedRatings,RatingDto.class);
    }

    @Override
    public void deleteRating(Long ratingId) {
        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + ratingId));
        this.ratingRepository.delete(rating);
    }
}
