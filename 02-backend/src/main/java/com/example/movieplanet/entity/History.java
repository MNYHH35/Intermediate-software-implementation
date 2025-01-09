package com.example.movieplanet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "watch_history")
@Data
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "watch_date")
    private LocalDateTime watchDate;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "type")
    private String type;

    @Column(name = "region")
    private String region;

    @Column(name = "creators")
    private String creators;

    @Column(name = "stars")
    private double stars;
}
