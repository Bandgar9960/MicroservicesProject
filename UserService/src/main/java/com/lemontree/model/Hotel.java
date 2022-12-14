package com.lemontree.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Long hotelId;

    private String hotelName;

    private String location;

    private String about;


    private boolean active;

    private Date createAt;


    private Date updateAt;


}
