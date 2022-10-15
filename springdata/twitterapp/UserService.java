package com.springdata.twitterapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public UserService(@Autowired TweetRepository tweetRepository, @Autowired UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //addTweetToUser

    public User addTweetToUser(Tweet tweet, User user){
        tweet.setUser(user);
        user.getTweets().add(tweet);
        return userRepository.save(user);
    }
}
