package com.fasttrackit.movieapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue
    Integer  id;
    @Column
    String name;
    @Column
    int movieYear;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    MovieRating movieRating;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Studio studio;

    @OneToMany(mappedBy = "movie", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Review> review;

    @Transient
    List<Actor> actors;

}
