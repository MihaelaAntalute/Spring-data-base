package com.springdata.jpaexamples.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }


    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable Long id) {
        try {
            return orderService.findById(id);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "order not found", e);
        }
    }

    @GetMapping("/orders/localdatebetween")
    public List<Order> findByLocalDateBetween(@RequestParam(required = false) String after, @RequestParam String before) {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate afterDate = LocalDate.parse(after, dtf);
        LocalDate beforeDate = LocalDate.parse(before, dtf);
        return orderService.findOrderByLocalDateBetween(afterDate,beforeDate);
    }

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@RequestBody Order updateOrder, @PathVariable Long id ){
        try {
            return orderService.updateOrder(updateOrder,id);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "order not found", e);
        }
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }


}
