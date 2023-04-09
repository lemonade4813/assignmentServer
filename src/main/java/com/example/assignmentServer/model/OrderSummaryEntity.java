package com.example.assignmentServer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;


@Entity
@Data
@Table(name="orderSummaryTable")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummaryEntity {

    @Id
    private String orderId;

    private Integer tableNum;

    private String useYn;

    private Integer totalPrice;

    private Integer totalQuantity;

    private String orderDate;


}
