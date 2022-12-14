package com.lemontree.hotel.service.impl;

import com.lemontree.hotel.constants.AppConstants;
import com.lemontree.hotel.dto.HotelDto;
import com.lemontree.hotel.exception.ResourceNotFoundException;
import com.lemontree.hotel.model.Hotel;
import com.lemontree.hotel.repository.HotelRepository;
import com.lemontree.hotel.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelDto saveHotel(HotelDto hotel) {
        Hotel hotel1 = this.modelMapper.map(hotel, Hotel.class);
        Hotel saveHotel = this.hotelRepository.save(hotel1);
        return this.modelMapper.map(saveHotel, HotelDto.class);
    }
    @Override
    public HotelDto getSingleHotel(Long hotelId) {
        Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + hotelId));
        return this.modelMapper.map(hotel, HotelDto.class);
    }
    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> allHotels = this.hotelRepository.findAll();
        return allHotels.stream().map((hotels) -> this.modelMapper.map(hotels, HotelDto.class)).toList();
    }
    @Override
    public HotelDto updateHotelDetails(HotelDto hotel, Long hotelId) {
        Hotel hotels = this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + hotelId));
        hotels.setHotelName(hotel.getHotelName());
        hotels.setLocation(hotel.getLocation());
        hotels.setAbout(hotel.getAbout());
        Hotel updatedHotel = this.hotelRepository.save(hotels);
        return this.modelMapper.map(updatedHotel, HotelDto.class);
    }
    @Override
    public void deleteHotelDetails(Long hotelId) {
        Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + hotelId));
    }
}
