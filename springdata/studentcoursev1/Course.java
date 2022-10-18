package com.springdata.studentcoursev1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany (mappedBy = "likedCourses")
    private Set<Student> likes ;

    public Course(){}
}
