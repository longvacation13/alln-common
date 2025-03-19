package com.ssg.alln.order.controller;

import com.ssg.alln.order.dto.CommonMsgEnum;
import com.ssg.alln.order.dto.CommonResponse;
import com.ssg.alln.order.dto.OrderRequest;
import com.ssg.alln.order.dto.OrderResponse;
import com.ssg.alln.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/products")
    public ResponseEntity<CommonResponse<OrderResponse>> getProducts() {
        return ResponseEntity.ok(orderService.getProducts());
    }

    @PostMapping("/order")
    public ResponseEntity<CommonResponse<String>> createOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println("Received Order ID: " + orderRequest.getOrderId());
        System.out.println("Received Order Date: " + orderRequest.getOrderDts());
        orderRequest.getItemInfo().forEach(item ->
                System.out.println("Item ID: " + item.getItemId() + ", Item Name: " + item.getItemNm())
        );

        return ResponseEntity.ok(
                CommonResponse.<String>builder()
                        .resultCode(CommonMsgEnum.서비스_요청_성공.getCode())
                        .resultMsg(CommonMsgEnum.서비스_요청_성공.getMsg())
                        .resultData("Order received successfully")
                        .build()
        );
    }
}
