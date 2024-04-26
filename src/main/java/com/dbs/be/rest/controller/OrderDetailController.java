package com.dbs.be.rest.controller;

import com.dbs.be.port.facade.OrderDetailFacade;
import com.dbs.be.rest.request.OrderDetailRequest;
import com.dbs.be.rest.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orderDetails")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailFacade orderDetailFacade;

    @PostMapping("/create-order")
    @Operation(tags = "OrderDetail APIs")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Void> createOrderDetail(@RequestBody OrderDetailRequest request){
        orderDetailFacade.saveOrderDetail(request);
        return BaseResponse.empty();
    }
}
