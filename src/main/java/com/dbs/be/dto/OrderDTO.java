package com.dbs.be.dto;

import com.dbs.be.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String orderCode;
    private String courseId;
    private Double price;

    public static OrderDTO fromDomain(Order order){
        return OrderDTO.builder()
                .orderCode(order.getId().getOrderDetail().getOrderCode())
                .courseId(order.getId().getCourse().getCourseId())
                .price(order.getPrice())
                .build();
    }
}
