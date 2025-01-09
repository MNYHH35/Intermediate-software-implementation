package com.example.movieplanet.service;

import com.example.movieplanet.dao.CheckoutRepository;
import com.example.movieplanet.dao.HistoryRepository;
import com.example.movieplanet.dao.MovieRepository;
import com.example.movieplanet.entity.Checkout;
import com.example.movieplanet.entity.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;


// 这个代码的作用是配合电影详细页的付费电影和免费电影做出一些动态变动，但是我还没想好做一些什么样的变动的，
// 所以暂时放在这里
@Service
@Transactional
public class MovieService {

    private MovieRepository movieRepository;

    private HistoryRepository historyRepository;

    private CheckoutRepository checkoutRepository;


    public MovieService(MovieRepository movieRepository,
                        CheckoutRepository checkoutRepository,
                        HistoryRepository historyRepository) {
        this.movieRepository = movieRepository;
        this.checkoutRepository = checkoutRepository;
        this.historyRepository = historyRepository;
    }

    public Movie checkoutMovie(String userEmail, Long movieId) throws Exception {
        Optional<Movie> movie = movieRepository.findById(movieId);

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());

        Checkout checkout = new Checkout(
                userEmail,
                date,
                movieId
        );

        checkoutRepository.save(checkout);

        return movie.get();
    }

    public Boolean checkoutMovieByUser(String userEmail, Long movieId) {
        Checkout validateCheckout = checkoutRepository.findByuserEmailAndMovieId(userEmail, movieId);
        if (validateCheckout != null) {
            return true;
        } else {
            return false;
        }
    }

    public int currentLoansCount(String userEmail) {
        return checkoutRepository.findMoviesByUserEmail(userEmail).size();
    }
}
