package com.lemantree.rating.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RatingDto {

    private Long ratingId;

    private Long userId;

    private Long hotelId;

    private String rating;

    private String feedback;

    private Date createAt;

    private Date updateAt;

}
