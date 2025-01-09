package com.example.movieplanet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "checkout")
@Data
public class Checkout {

    public Checkout() {
    }

    public Checkout(String userEmail, Date checkout_date, Long movieId) {
        this.userEmail = userEmail;
        this.checkout_date = checkout_date;
        this.movieId = movieId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private Date checkout_date;
}
