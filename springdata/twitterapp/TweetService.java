package com.springdata.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TweetService {

    private TweetRepository tweetRepository;
    private CommentRepository commentRepository;

    public TweetService(@Autowired TweetRepository tweetRepository,@Autowired CommentRepository commentRepository) {
        this.tweetRepository = tweetRepository;
        this.commentRepository=commentRepository;
    }

    public Tweet findByText(String text){
        return tweetRepository.findByText(text);
    }


    public Tweet addCommentToTweet(Tweet tweet,Comment comment){
        comment.setTweet(tweet);
        tweet.getComments().add(comment);
        return tweetRepository.save(tweet);
    }
    public void deleteAllCommentsFromTweet(Tweet tweet){
        commentRepository.deleteAll(tweet.getComments());
    }
}
