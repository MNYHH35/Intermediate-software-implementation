package com.example.movieplanet.dao;

import com.example.movieplanet.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByMovieId(@RequestParam("movie_id")Long movieId,
                               Pageable pageable);

    Review findByUserEmailAndMovieId(@RequestParam("user_email")String userEmail,
                                     @RequestParam("movie_id")Long movieId);
}