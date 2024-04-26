package com.dbs.be.dto;

import com.dbs.be.domain.order.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderDetailDTO {
    private String orderCode;
    private Date payTime;
    private String payMethod;
    private double totalPrice;
    private String studentId;

    public static OrderDetailDTO fromDomain(OrderDetail orderDetail){
        return OrderDetailDTO.builder()
                .orderCode(orderDetail.getOrderCode())
                .payTime(orderDetail.getPaymentTime())
                .payMethod(orderDetail.getPaymentMethod())
                .totalPrice(orderDetail.getTotalPrice())
                .studentId(orderDetail.getStudent().getId())
                .build();
    }
}
