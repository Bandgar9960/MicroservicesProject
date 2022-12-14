package com.lemontree.hotel.controller;

import com.lemontree.hotel.constants.AppConstants;
import com.lemontree.hotel.dto.ApiResponse;
import com.lemontree.hotel.dto.HotelDto;
import com.lemontree.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> saveHotels(@RequestBody HotelDto hotel){
        return new ResponseEntity<>(this.hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getSingleHotel(@PathVariable Long hotelId){
        return new ResponseEntity<>(this.hotelService.getSingleHotel(hotelId),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        return new ResponseEntity<>(this.hotelService.getAllHotels(),HttpStatus.OK);
    }
    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotelsDetails(@RequestBody HotelDto hotel,@PathVariable Long hotelId){
        return new ResponseEntity<>(this.hotelService.updateHotelDetails(hotel,hotelId),HttpStatus.CREATED);
    }
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<ApiResponse> deleteHotelDetails(@PathVariable Long hotelId){
        this.hotelService.deleteHotelDetails(hotelId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.USER_DELETE + hotelId,true),HttpStatus.OK);
    }
}
