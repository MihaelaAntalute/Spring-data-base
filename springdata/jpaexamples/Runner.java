package com.springdata.jpaexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class Runner implements CommandLineRunner {

    private OrderRepository orderRepository;

    public Runner(@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order("tip1", LocalDate.of(2022,8,3),OrderStatus.PENDING);
        Order order2 = new Order("tip2", LocalDate.of(2022,8,3),OrderStatus.PENDING);
        Order order3 = new Order("tip3", LocalDate.of(2022,8,3),OrderStatus.PENDING);
        orderRepository.save(order);
        orderRepository.save(order2);
        orderRepository.save(order3);

        Order foundOrder = orderRepository.findById(1L).orElse(new Order());
        System.out.println(foundOrder);
        order3.setOrderStatus(OrderStatus.RECEIVED);
        orderRepository.save(order3);

        //orderRepository.delete(order2);
        //System.out.println(orderRepository.findAll());

        //orderRepository.save(order2);

        System.out.println(orderRepository.findTop3ByOrderByProductType());
        System.out.println(orderRepository.findAllByOrderStatusIn(Arrays.asList(OrderStatus.SHIPPED)));

    }
}
