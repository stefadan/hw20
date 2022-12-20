package com.fasttrackit.movieapplication.controller;

import com.fasttrackit.movieapplication.model.Movie;
import com.fasttrackit.movieapplication.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")//http://localhost:port/movies
public class MovieController {

    private final MovieService movieService;

    @GetMapping//GET http://localhost:port/movies

    public List<Movie> getAll(){
        System.out.println("Requested all movies");
        return movieService.getAllMovies();
    }


}
