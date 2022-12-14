package com.lemontree.dto;

import com.lemontree.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private Long ratingId;
    private Long userId;
    private Long hotelId;
    private String rating;
    private String feedback;
    private Hotel hotel;


}
