package com.dbs.be.domain.order;

import com.dbs.be.domain.user.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderDetail {
    @Id
    @Column(name = "order_code")
    private String orderCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_time")
    private Date paymentTime;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_student")
    private Student student;

    @OneToMany(mappedBy = "id.orderDetail", cascade = CascadeType.ALL)
    private List<Order> orders;

}
