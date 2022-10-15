package com.springdata.twitterapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String street;

    @Column
    private int number;

    public UserDetails(){}
}
