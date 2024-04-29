package com.dbs.be.domain.user;

import com.dbs.be.domain.order.OrderDetail;
import com.dbs.be.domain.studentCourse.StudentCourse;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourses;

    public Student(String id, String username, String password, String email, String phoneNumber, String fullName, String gender, Date bdate, String addr) {
        super(id, username, password, email, phoneNumber, fullName, gender, bdate, addr);
    }
}
