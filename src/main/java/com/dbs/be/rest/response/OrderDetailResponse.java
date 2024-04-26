package com.dbs.be.rest.response;

import com.dbs.be.dto.OrderDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderDetailResponse {
    private String orderCode;
    private Date payTime;
    private String payMethod;
    private double totalPrice;
    private String studentId;

    public static OrderDetailResponse toResponse(OrderDetailDTO orderDetailDTO){
        return OrderDetailResponse.builder()
                .orderCode(orderDetailDTO.getOrderCode())
                .payTime(orderDetailDTO.getPayTime())
                .payMethod(orderDetailDTO.getPayMethod())
                .totalPrice(orderDetailDTO.getTotalPrice())
                .studentId(orderDetailDTO.getStudentId())
                .build();
    }
}
