package com.code.graphql.serive.impl;

import com.code.graphql.entity.Order;
import com.code.graphql.exception.ExceptionHelper;
import com.code.graphql.repository.OrderRepository;
import com.code.graphql.serive.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getSingleOrder(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFountException);
       return order;
    }

    @Override
    public Order updateOrder(Order order, int orderId) {
        return null;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFountException);
        orderRepository.delete(order);
        return true;
    }


}
