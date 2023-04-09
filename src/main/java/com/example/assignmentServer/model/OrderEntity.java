package com.example.assignmentServer.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;



@Entity
@Data
@Table(name="orderTable")
@IdClass(Order.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

    @Id
    private String orderId;
    @Id
    private String menuId;

    private Integer tableNum;
    private String menuName;
    private Integer price;
    private Integer quantity;

}
