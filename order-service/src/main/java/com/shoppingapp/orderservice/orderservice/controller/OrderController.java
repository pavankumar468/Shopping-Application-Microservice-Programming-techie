package com.shoppingapp.orderservice.orderservice.controller;

import com.shoppingapp.orderservice.orderservice.dto.OrderRequest;
import com.shoppingapp.orderservice.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor // it will create all types constructors at compile time
public class OrderController {
   private final OrderService orderService;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return  "Order placed successfully";
    }

    @GetMapping("/getorder")
    public String getorder(){
        return "getorder pavan";
    }

}
