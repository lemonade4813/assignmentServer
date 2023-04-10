package com.example.assignmentServer.persistence;

import com.example.assignmentServer.model.OrderEntity;
import com.example.assignmentServer.model.OrderSummaryEntity;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByOrderId(String orderId);

}
