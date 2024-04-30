package com.dbs.be.domain.order;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "order_code")
    private OrderDetail orderDetail;

}
