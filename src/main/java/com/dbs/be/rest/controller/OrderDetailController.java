package com.dbs.be.rest.controller;

import com.dbs.be.port.facade.OrderDetailFacade;
import com.dbs.be.rest.request.OrderDetailRequest;
import com.dbs.be.rest.request.OrderRequest;
import com.dbs.be.rest.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailFacade orderDetailFacade;

    @PostMapping("/create-order")
    @Operation(tags = "Order APIs")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Void> createOrderDetail(@RequestBody OrderRequest request){
        orderDetailFacade.saveOrder(request);
        return BaseResponse.empty();
    }
}
