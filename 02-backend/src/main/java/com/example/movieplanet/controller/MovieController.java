package com.example.movieplanet.controller;

import com.example.movieplanet.entity.Movie;
import com.example.movieplanet.service.MovieService;
import com.example.movieplanet.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(@RequestHeader(value = "Authorization") String token){
        String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
        return movieService.currentLoansCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutMovieByUser(@RequestHeader(value = "Authorization") String token,
                                       @RequestParam Long movieId) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
        return movieService.checkoutMovieByUser(userEmail, movieId);
    }

    @PutMapping("/secure/checkout")
    public Movie checkoutMovie(@RequestHeader(value = "Authorization") String token,
                               @RequestParam Long movieId) throws Exception {
        String userEmail = "testuser@email.com";
        return movieService.checkoutMovie(userEmail, movieId);
    }

}
