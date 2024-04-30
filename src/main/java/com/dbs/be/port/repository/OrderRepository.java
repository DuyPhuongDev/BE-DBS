package com.dbs.be.port.repository;

import com.dbs.be.domain.order.Order;
import com.dbs.be.domain.order.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderID> {
}
