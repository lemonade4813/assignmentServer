package com.example.assignmentServer.service;


import com.example.assignmentServer.model.OrderEntity;
import com.example.assignmentServer.model.OrderSummaryEntity;
import com.example.assignmentServer.persistence.OrderRepository;
import com.example.assignmentServer.persistence.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderSummaryRepository orderSummaryRepository;

    public OrderEntity create(OrderEntity orderEntity){

        return orderRepository.save(orderEntity);

    }


    public OrderSummaryEntity createSummary(OrderSummaryEntity orderSummaryEntity){

        return orderSummaryRepository.save(orderSummaryEntity);

    }

    public OrderSummaryEntity retrieveSummary(int tableNum){
        return orderSummaryRepository.findByTableNum(tableNum);
    }

    public List<OrderEntity> retrieve(int tableNum){
        return orderRepository.findByTableNum(tableNum);

    }

}
