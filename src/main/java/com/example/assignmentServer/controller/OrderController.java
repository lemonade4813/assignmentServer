package com.example.assignmentServer.controller;

import com.example.assignmentServer.dto.OrderDTO;
import com.example.assignmentServer.dto.OrderSummaryDTO;
import com.example.assignmentServer.dto.ResponseListDTO;
import com.example.assignmentServer.dto.ResponseDTO;
import com.example.assignmentServer.model.OrderEntity;
import com.example.assignmentServer.model.OrderSummaryEntity;
import com.example.assignmentServer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/detail")
    public ResponseEntity<?> retrieveOrderDetail(@RequestParam String orderId){


        List<OrderEntity> orderEntities = orderService.retrieve(orderId);

        List<OrderDTO> orderDtos = orderEntities.stream().map(OrderDTO::new).collect(Collectors.toList());

        ResponseListDTO<OrderDTO> response = ResponseListDTO.<OrderDTO>builder().data(orderDtos).build();

        return ResponseEntity.ok().body(response);

    }
    @PostMapping("/save")
    public ResponseEntity<?> saveOrder(@RequestBody List<OrderDTO> orderDTOList){

    System.out.println(orderDTOList);


    try{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Date now = new Date();
        String nowTime = sdf.format(now);

        String orderId = "ORDER_" + nowTime;

        int price = 0;
        int quantity = 0;

        for(OrderDTO order : orderDTOList ){
            OrderEntity orderEntity = OrderEntity.builder()
                                                     .tableNum(order.getTableNum())
                                                     .orderId(orderId)
                                                     .menuId(order.getMenuId())
                                                     .menuName(order.getMenuName())
                                                     .quantity(order.getQuantity())
                                                     .price(order.getPrice())
                                                     .build();
            orderService.create(orderEntity);

            price += order.getPrice() * order.getQuantity();
            quantity += order.getQuantity();
        };


        OrderSummaryEntity orderSummaryEntity = OrderSummaryEntity.builder().orderId(orderId).orderDate(nowTime).useYn("Y").tableNum(orderDTOList.get(0).getTableNum()).totalQuantity(quantity).totalPrice(price).build();


        orderService.createSummary(orderSummaryEntity);


        return ResponseEntity.ok().body("정상적으로 주문 처리가 진행되었습니다.");
    }
    catch (Exception e){

        ResponseListDTO responseListDTO = ResponseListDTO.builder().error(e.getMessage()).build();
        return ResponseEntity.badRequest().body(responseListDTO);
        }
    }

    @GetMapping("/summary")
    public ResponseEntity<?> retrieveOrderSummary(@RequestParam int tableNum){

        try {
            OrderSummaryEntity orderSummary = orderService.retrieveSummary(tableNum);

            if(orderSummary == null){
                throw new RuntimeException("예약 가능한 테이블입니다.");
            }

            ResponseDTO<OrderSummaryDTO> response = ResponseDTO.<OrderSummaryDTO>builder().data(new OrderSummaryDTO(orderSummary)).build();

            return ResponseEntity.ok().body(response);
        }
        catch(Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);

        }
    }

    @GetMapping("/update")
            public void updateOrderSummary(@RequestParam String orderId){
            orderService.updateOrderSummary(orderId);
    }
}
