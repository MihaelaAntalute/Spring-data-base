package com.springdata.studentcoursev2;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;


    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> registrations;

    public Student(){}
}
