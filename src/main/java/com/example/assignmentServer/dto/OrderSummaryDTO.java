package com.example.assignmentServer.dto;


import com.example.assignmentServer.model.OrderSummaryEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderSummaryDTO {

    @Id
    private String orderId;

    private Integer tableNum;

    private String useYn;

    private Integer totalPrice;

    private Integer totalQuantity;

    private String orderDate;

    public OrderSummaryDTO(OrderSummaryEntity orderSummaryEntity){

        this.orderId = orderSummaryEntity.getOrderId();
        this.tableNum = orderSummaryEntity.getTableNum();
        this.useYn = orderSummaryEntity.getUseYn();
        this.totalPrice = orderSummaryEntity.getTotalPrice();
        this.totalQuantity = orderSummaryEntity.getTotalQuantity();
        this.orderDate = orderSummaryEntity.getOrderDate();

    }

}
