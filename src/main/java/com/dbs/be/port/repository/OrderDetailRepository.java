package com.dbs.be.port.repository;

import com.dbs.be.domain.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    @Procedure(procedureName = "insert_order_detail")
    void saveOrderDetail(@Param("orderCode") String orderCode,
                         @Param("patTime") Date payTime,
                         @Param("payMethod") String payMethod,
                         @Param("totalPrice") double totalPrice,
                         @Param("studentId") String studentId);
}
