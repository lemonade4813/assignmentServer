package com.example.assignmentServer.persistence;

import com.example.assignmentServer.model.OrderEntity;
import com.example.assignmentServer.model.OrderSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSummaryRepository extends JpaRepository<OrderSummaryEntity, Long>
{
    OrderSummaryEntity findByTableNum(int tableNum);

}
