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

    public Runner(@Autowired UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("user1");
        userService.saveUser(user);
        Tweet tweet = new Tweet();
        tweet.setText("text1");
        User editedUser = userService.addTweetToUser(tweet,user);


    }
}
