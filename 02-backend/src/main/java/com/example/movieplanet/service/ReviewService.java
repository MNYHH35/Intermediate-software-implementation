package com.example.movieplanet.service;

import com.example.movieplanet.requestmodel.ReviewRequest;
import com.example.movieplanet.dao.MovieRepository;
import com.example.movieplanet.dao.ReviewRepository;
import com.example.movieplanet.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class ReviewService {

    private MovieRepository movieRepository;

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(MovieRepository movieRepository,
                         ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail,
                           ReviewRequest reviewRequest) throws Exception {
        Review validateReview = reviewRepository.findByUserEmailAndMovieId(userEmail,
                reviewRequest.getMovieId());
        if (validateReview != null) {
            throw new Exception("您已经发布评论");
        }

        Review review = new Review();
        review.setMovieId(reviewRequest.getMovieId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);
        if (reviewRequest.getReviewDescription().isPresent()) {
            review.setReviewDescription(reviewRequest.getReviewDescription().map(
                    Object::toString
            ).orElse(null));
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);

    }

    public Boolean userReviewListed(String userEmail, Long movieId) {

        Review validateReview = reviewRepository.findByUserEmailAndMovieId(userEmail, movieId);
        if (validateReview != null) {
            return true;
        } else {
            return false;
        }
    }

}ff