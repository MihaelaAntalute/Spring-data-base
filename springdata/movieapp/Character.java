package com.springdata.movieapp;

import com.springdata.studentcoursev1.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Character {
    @Id
    @GeneratedValue
    private long id;

    private String name;


    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies ;
}
