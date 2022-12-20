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
public class Review {
    @Id
    @GeneratedValue
    int id;
    @Column
    String text;
    @Column
    String reviewer;

    @ManyToOne
    @JsonIgnore
    private Movie movie;

    public Review(String text, String reviewer) {
        this.text = text;
        this.reviewer = reviewer;
    }
}
