package com.springdata.movieapp;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Franchise {

    @Id
    @GeneratedValue
    private long id;

    private String name;


    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL)
    Set<Movie> movies;


}
