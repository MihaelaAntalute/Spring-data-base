package com.springdata.twitterapp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    List<Comment> comments;

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(){

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        if (this.comments == null){
            this.comments = new ArrayList<>();
        }
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
