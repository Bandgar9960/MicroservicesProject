package com.lemontree.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HOTEL_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOTEL_ID")
    private Long hotelId;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @Column(name = "HOTEL_LOCATION")
    private String location;

    @Column(name = "HOTEL_ABOUT")
    private String about;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "CREATE_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @UpdateTimestamp
    private Date updateAt;

}
