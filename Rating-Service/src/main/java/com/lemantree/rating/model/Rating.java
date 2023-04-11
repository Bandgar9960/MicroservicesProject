package com.lemantree.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RATING_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATING_ID")
    private Long ratingId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "HOTEL_ID")
    private Long hotelId;
    @Column(name = "RATING")
    private String rating;
    @Column(name = "FEEDBACK")
    private String feedback;

    @Column(name = "CREATE_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @UpdateTimestamp
    private Date updateAt;
}
