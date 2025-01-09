package com.example.movieplanet.dao;

import com.example.movieplanet.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    Checkout findByuserEmailAndMovieId(String userEmail, Long movieId);

    List<Checkout> findMoviesByUserEmail(String userEmail);
}
