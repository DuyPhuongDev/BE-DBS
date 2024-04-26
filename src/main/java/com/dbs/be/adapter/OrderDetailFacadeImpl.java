package com.dbs.be.adapter;

import com.dbs.be.port.facade.OrderDetailFacade;
import com.dbs.be.port.repository.OrderDetailRepository;
import com.dbs.be.rest.request.OrderDetailRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderDetailFacadeImpl implements OrderDetailFacade {
    private final OrderDetailRepository orderDetailRepository;
    @Override
    @Transactional
    public void saveOrderDetail(OrderDetailRequest request) {
        orderDetailRepository.saveOrderDetail(request.getOrderCode(),
                request.getPaymentTime(),
                request.getPaymentMethod(),
                request.getTotalPrice(),
                request.getStudentId());
    }
}
