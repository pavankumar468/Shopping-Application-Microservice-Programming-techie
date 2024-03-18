package com.shoppingapp.orderservice.orderservice.service;

import com.shoppingapp.orderservice.orderservice.dto.OrderRequest;
import com.shoppingapp.orderservice.orderservice.model.Order;
import com.shoppingapp.orderservice.orderservice.model.OrderLineItems;
import com.shoppingapp.orderservice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    public void placeOrder( OrderRequest orderRequest){
        // map order request to order
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream().map(dto->
            OrderLineItems.builder()
                    .skucode(dto.getSkucode())
                    .price(dto.getPrice())
                    .quantity(dto.getQuantity())
                    .build()
        ).collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItems);
        orderRepo.save(order);
    }
}
