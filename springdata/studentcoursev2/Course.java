package com.springdata.studentcoursev2;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> registrations ;

    public Course(){}
}
