package com.example.movieplanet.dao;

import com.example.movieplanet.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
public interface HistoryRepository extends JpaRepository<History, Long> {
    Page<History> findMoviesByUserEmail(@RequestParam("userEmail") String userEmail, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO watch_history (user_email, movie_id, watch_date, title, description, release_date, cover_image, type, region, creators, stars) " +
            "VALUES (:userEmail, :movieId, :watchDate, :title, :description, :releaseDate, :coverImage, :type, :region, :creators, :stars)", nativeQuery = true)
    void addHistoryRecord(String userEmail, int movieId, LocalDateTime watchDate, String title, String description, LocalDate releaseDate,
                          String coverImage, String type, String region, String creators, double stars);

}


