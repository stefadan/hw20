package com.fasttrackit.movieapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRating {
    @Id
    @GeneratedValue
    Integer id;
    @Column
    int rating;
    @Column
    String agency;

    @OneToOne(mappedBy = "movieRating")
    @JsonIgnore
    private Movie rateOf;

    public MovieRating(int rating, String agency) {
        this.rating = rating;
        this.agency = agency;
    }
}
