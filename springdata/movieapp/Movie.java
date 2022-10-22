package com.springdata.movieapp;


import com.springdata.studentcoursev1.Course;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    Franchise franchise;

    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name ="character_id")
    )
    private Set<Character> characters;
}
