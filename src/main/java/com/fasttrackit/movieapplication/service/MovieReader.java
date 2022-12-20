package com.fasttrackit.movieapplication.service;

import com.fasttrackit.movieapplication.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieReader {

    public static int movieId = 0;
    @Value("${file.movie}")
    private String fileMoviePath;
    public List<Movie> getMovies() {

        try {
            return Files.lines(Path.of(fileMoviePath))
                    .map(this::lineToMovie)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
//Movie1|2020|5|AgencyRating1|Studio1|StudioAddress1|TextReview1~TextReview1|Rewier1|Actor1~1975~Actor2~1976
    private Movie lineToMovie(String line) {
        String[] movieParts = line.split("\\|");
        return new Movie(movieId++,
                movieParts[0],
                Integer.valueOf(movieParts[1]),
                new MovieRating(Integer.valueOf(movieParts[2]), movieParts[3]),
                new Studio(movieParts[4], movieParts[5]),
                new ArrayList<Review>(Arrays.asList(
                        new Review(movieParts[6], movieParts[7])
                )),
                new ArrayList<Actor>(Arrays.asList(
                        new Actor(movieParts[8], Integer.valueOf(movieParts[9]))
                ))
        );


    }
    private List<String> parseReview(String line) {
        return Arrays.stream(line.split("~")).toList();
    }

    private List<String> parseItem(String line) {
        return Arrays.stream(line.split("#")).toList();
    }



}
