package com.lemontree.hotel.service;

import com.lemontree.hotel.dto.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto saveHotel(HotelDto hotel);

    HotelDto getSingleHotel(Long hotelId);

    List<HotelDto> getAllHotels();

    HotelDto updateHotelDetails(HotelDto hotel,Long hotelId);

    void deleteHotelDetails(Long hotelId);
}
