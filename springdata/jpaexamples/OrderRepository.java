package com.springdata.jpaexamples;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

     Order findByOrderStatus(OrderStatus orderStatus);
     List<Order> findAllByOrderStatusIn(List<OrderStatus> orderStatusList);
     Order findOrderByLocalDateBetween(LocalDate after, LocalDate before);
     Order findOrderByProductTypeContainsAndLocalDateIsAfter(String productType, LocalDate after);
     List<Order> findTop3ByOrderByProductType();

     Order findByProductType(String productType);

     //select from orders o where o.orderStatus = "PENDING"
     // query made using JPQL language (enhanced SQL)
     @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :orderStatus", nativeQuery = false)
     List<Order> findAllOrdersByOrderStatus (@Param("orderStatus") OrderStatus orderStatus);

}
