package com.example.assignmentServer.persistence;

import com.example.assignmentServer.model.OrderEntity;
import com.example.assignmentServer.model.OrderSummaryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderSummaryRepository extends JpaRepository<OrderSummaryEntity, Long>
{
    @Query(nativeQuery = true, value = "select * from order_summary_table where table_num = :tableNum and use_yn = 'Y'")
    OrderSummaryEntity findByTableNum(int tableNum);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update order_summary_table set use_yn = 'N' where order_id = :orderId")
    void updateOrderSummary(String orderId);
}
