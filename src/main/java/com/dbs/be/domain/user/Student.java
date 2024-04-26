package com.dbs.be.domain.user;

import com.dbs.be.domain.order.OrderDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User{
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
