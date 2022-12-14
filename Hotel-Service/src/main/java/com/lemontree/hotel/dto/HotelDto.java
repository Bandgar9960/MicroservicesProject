package com.lemontree.hotel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HotelDto {


    private Long hotelId;

    private String hotelName;

    private String location;

    private String about;

    private boolean active;

    private Date createAt;

    private Date updateAt;

}
