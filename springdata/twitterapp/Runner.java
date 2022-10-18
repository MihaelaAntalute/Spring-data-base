package com.springdata.twitterapp;

import com.springdata.jpaexamples.Order;
import com.springdata.jpaexamples.OrderRepository;
import com.springdata.jpaexamples.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class Runner implements CommandLineRunner {

    private UserService userService;

    private TweetService tweetService;

    private CommentService commentService;

    public Runner(@Autowired UserService userService, @Autowired TweetService tweetService, @Autowired CommentService commentService) {
        this.userService = userService;
        this.tweetService = tweetService;
        this.commentService = commentService;
    }

    @Override
    public void run(String... args) throws Exception {
        //TESTING CREATE OPERATIONS
        User user = new User();
        user.setName("user1");
        userService.saveUser(user);
        Tweet tweet = new Tweet();
        tweet.setText("text1");
        User editedUser = userService.addTweetToUser(tweet,user);
        Comment comment = new Comment();
        comment.setText("comment1");
        Tweet foundTweet = tweetService.findByText("text1");
        Tweet editedTweet = tweetService.addCommentToTweet(foundTweet,comment);

        //TESTING READ OPERATIONS
        System.out.println("ALL COMMENT BY TWEET"+commentService.findAllByTweet(editedTweet));
        System.out.println("ALL COMMENT BY TWEET"+commentService.findAllByUser(editedUser));

        //TESTING DELETE OPERATIONS
//        userService.removeTweetFromUser(foundTweet,editedUser);
        tweetService.deleteAllCommentsFromTweet(editedTweet);
        userService.deleteAllTweetsFromUser(editedUser);
        userService.deleteUser(editedUser);


        //TESTING UPDATE OPERATIONS
//        User user2 = new User();
//        user2.setName("user2");
//        User savedUser = userService.saveUser(user2);
//        savedUser.setName("user3");
//        User updatedUser = userService.updateUser(savedUser);







    }
}
