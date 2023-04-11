package com.lemontree.model;

import com.lemontree.dto.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER_DETAIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USER_ABOUT")
    private String about;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "CREATE_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @UpdateTimestamp
    private Date updateAt;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
