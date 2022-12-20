package com.fasttrackit.movieapplication.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue
    Integer id;
    @Column
    String name;
    @Column
    int birhYear;

    public Actor(String name, int birhYear) {
        this.name = name;
        this.birhYear = birhYear;
    }

}
