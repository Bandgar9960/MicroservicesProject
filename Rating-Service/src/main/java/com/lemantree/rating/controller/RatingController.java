package com.lemantree.rating.controller;

import com.lemantree.rating.constants.AppConstants;
import com.lemantree.rating.dto.ApiResponse;
import com.lemantree.rating.dto.RatingDto;
import com.lemantree.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDto> saveRatings(@RequestBody RatingDto rating) {
        return new ResponseEntity<>(this.ratingService.saveRatings(rating), HttpStatus.CREATED);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingDto> getSingleRatings(@PathVariable Long ratingId) {
        return new ResponseEntity<>(this.ratingService.getSingleRating(ratingId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        return new ResponseEntity<>(this.ratingService.getAllRatings(), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingDto>> getAllRatingsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(this.ratingService.getAllRatingsByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingDto>> getAllRatingsByHotelId(@PathVariable Long hotelId) {
        return new ResponseEntity<>(this.ratingService.getAllRatingsByHotelId(hotelId), HttpStatus.OK);
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<RatingDto> updateRatings(@RequestBody RatingDto rating, @PathVariable Long ratingId) {
        return new ResponseEntity<>(this.ratingService.updateRatings(rating, ratingId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<ApiResponse> deleteRatings(@PathVariable Long ratingId) {
        this.ratingService.deleteRating(ratingId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.USER_DELETE + ratingId, true), HttpStatus.OK);
    }
}
