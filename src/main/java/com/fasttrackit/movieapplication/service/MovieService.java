package com.fasttrackit.movieapplication.service;

import com.fasttrackit.movieapplication.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieReader movieReader, MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        movieRepository.saveAll(movieReader.getMovies());
        System.out.println("Finished reading movies");
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


}
