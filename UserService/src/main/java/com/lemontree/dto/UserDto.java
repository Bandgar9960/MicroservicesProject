package com.lemontree.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class UserDto {

    private Long userId;
    private String name;
    private String email;
    private String about;
    private boolean active;
    private Date createAt;
    private Date updateAt;
    private List<Rating> ratings=new ArrayList<>();

}
