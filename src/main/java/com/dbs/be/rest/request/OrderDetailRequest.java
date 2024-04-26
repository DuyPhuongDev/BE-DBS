package com.dbs.be.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class OrderDetailRequest extends BaseRequest{
    private String orderCode;
    private Date paymentTime;
    private String paymentMethod;
    private Double totalPrice;
    private String studentId;
}
