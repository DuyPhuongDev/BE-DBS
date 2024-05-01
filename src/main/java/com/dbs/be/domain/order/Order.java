package com.dbs.be.domain.order;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @EmbeddedId
    private OrderID id;

    private Double price;
}
