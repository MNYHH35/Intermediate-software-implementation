package com.example.movieplanet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "type")
    private String type;

    @Column(name = "region")
    private String region;

    @Column(name = "creators")
    private String creators;

    @Column(name = "vip")
    private int vip;

    @Column(name = "price")
    private double price;

    @Column(name = "stars")
    private double stars;

    @Column(name = "week_ranking")
    private int weekRanking;

    @Column(name = "month_ranking")
    private int monthRanking;

    @Column(name = "total_ranking")
    private int totalRanking;

    @Column(name = "reviews_ranking")
    private int reviewsRanking;
}
