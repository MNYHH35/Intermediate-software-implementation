package com.example.movieplanet.dao;

import com.example.movieplanet.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    Page<Movie> findByTypeContaining(@RequestParam("type") String type, Pageable pageable);

    Page<Movie> findByRegionContaining(@RequestParam("region") String region, Pageable pageable);

    Page<Movie> findByCreatorsContaining(@RequestParam("creators") String creators, Pageable pageable);


    @Query("SELECT m FROM Movie m ORDER BY m.weekRanking ASC")
    Page<Movie> findAllOrderByWeekRankingDesc(Pageable pageable);

     //按 monthRanking 排序
    @Query("SELECT m FROM Movie m ORDER BY m.monthRanking ASC")
    Page<Movie> findAllOrderByMonthRankingDesc(Pageable pageable);

     //按 totalRanking 排序
    @Query("SELECT m FROM Movie m ORDER BY m.totalRanking ASC")
    Page<Movie> findAllOrderByTotalRankingDesc(Pageable pageable);

     //按 reviewsRanking 排序
    @Query("SELECT m FROM Movie m ORDER BY m.reviewsRanking ASC")
    Page<Movie> findAllOrderByReviewsRankingDesc(Pageable pageable);

    @Query("SELECT m FROM Movie m ORDER BY m.movieId ASC")
    Page<Movie> findAllOrderByMovieId(Pageable pageable);

    @Query("SELECT COUNT(m) FROM Movie m WHERE m.region LIKE %:region%")
    int findNumByRegion(@Param("region") String region);
}
