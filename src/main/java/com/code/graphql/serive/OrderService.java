package com.code.graphql.serive;

import com.code.graphql.entity.Order;

import java.util.List;

public interface OrderService {
    //creating Order
    Order createOrder(Order order);
    //getting All Orders
    List<Order> getAllOrders();
    //getting single Order
    Order getSingleOrder(int orderId);
    //update by Order
    Order updateOrder(Order order,int orderId);
    //delete by OrderId
    boolean deleteOrder(int orderId);
}
