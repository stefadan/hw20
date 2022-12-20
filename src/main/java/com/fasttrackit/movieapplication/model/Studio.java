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
public class Studio {
    @Id
    @GeneratedValue
    Integer id;
    @Column
    String name;
    @Column
    String address;

    @OneToOne(mappedBy = "studio")
    @JsonIgnore
    private Movie studioFor;

    public Studio(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
