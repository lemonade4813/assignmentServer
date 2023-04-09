package com.example.assignmentServer.dto;


import com.example.assignmentServer.model.OrderEntity;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Integer tableNum;
    private String menuId;
    private String menuName;
    private Integer price;
    private Integer quantity;
    private String orderDate;
    private String orderId;

    public OrderDTO(OrderEntity orderEntity){

        this.tableNum = orderEntity.getTableNum();
        this.menuId = orderEntity.getMenuId();
        this.menuName = orderEntity.getMenuName();
        this.price = orderEntity.getPrice();
        this.quantity = orderEntity.getQuantity();
        this.orderId = orderEntity.getOrderId();
    }
}
