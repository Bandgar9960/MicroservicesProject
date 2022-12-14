package com.lemantree.rating.service;

import com.lemantree.rating.dto.RatingDto;

import java.util.List;

public interface RatingService {

    RatingDto saveRatings(RatingDto rating);

    RatingDto getSingleRating(Long ratingId);

    List<RatingDto> getAllRatings();

    List<RatingDto> getAllRatingsByUserId(Long userId);

    List<RatingDto> getAllRatingsByHotelId(Long hotelId);

    RatingDto updateRatings(RatingDto rating, Long ratingId);

    void deleteRating(Long ratingId);
}
