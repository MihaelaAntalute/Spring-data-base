package com.springdata.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(@Autowired CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllByTweet(Tweet tweet){
        return  commentRepository.findAllByTweet(tweet);
    }

    public List<Comment> findAllByUser(User user){
        return  commentRepository.findAllByTweet_User(user);
    }

}
