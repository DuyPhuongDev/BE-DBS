package com.dbs.be.domain.order;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@IdClass(OrderID.class)
@Table(name = "order")
public class Order {
    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_code")
    private OrderDetail orderDetail;

    private Double price;
}
