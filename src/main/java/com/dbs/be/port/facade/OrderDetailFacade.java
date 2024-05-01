package com.dbs.be.port.facade;

import com.dbs.be.rest.request.OrderDetailRequest;
import com.dbs.be.rest.request.OrderRequest;

public interface OrderDetailFacade {
    void saveOrderDetail(OrderDetailRequest request);

    void saveOrder(OrderRequest request);
}
