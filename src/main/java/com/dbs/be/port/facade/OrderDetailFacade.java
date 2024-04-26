package com.dbs.be.port.facade;

import com.dbs.be.rest.request.OrderDetailRequest;

public interface OrderDetailFacade {
    void saveOrderDetail(OrderDetailRequest request);
}
