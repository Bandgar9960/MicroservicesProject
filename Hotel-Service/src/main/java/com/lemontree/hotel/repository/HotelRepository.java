package com.lemontree.hotel.repository;

import com.lemontree.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
