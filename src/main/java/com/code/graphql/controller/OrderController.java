package com.code.graphql.controller;

import com.code.graphql.entity.Order;
import com.code.graphql.entity.User;
import com.code.graphql.serive.OrderService;
import com.code.graphql.serive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    OrderService orderService;
    @Autowired
    UserService userService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
// create order
    @MutationMapping
    public Order createOrder(@Argument String orderDetails,@Argument String address,@Argument int price,@Argument int userId){

        User user = userService.getSingleUser(userId);
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        Order orderNew = orderService.createOrder(order);
        return orderNew;
    }

    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        Order singleOrder = orderService.getSingleOrder(orderId);
        return singleOrder;
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);

    }
}
