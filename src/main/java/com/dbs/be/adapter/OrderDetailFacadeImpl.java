package com.dbs.be.adapter;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.order.Order;
import com.dbs.be.domain.order.OrderDetail;
import com.dbs.be.domain.order.OrderID;
import com.dbs.be.domain.user.Student;
import com.dbs.be.port.facade.OrderDetailFacade;
import com.dbs.be.port.repository.CourseRepository;
import com.dbs.be.port.repository.OrderDetailRepository;
import com.dbs.be.port.repository.OrderRepository;
import com.dbs.be.port.repository.StudentRepository;
import com.dbs.be.rest.request.OrderDetailRequest;
import com.dbs.be.rest.request.OrderRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//import java.sql.Date;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderDetailFacadeImpl implements OrderDetailFacade {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    @Override
    @Transactional
    public void saveOrderDetail(OrderDetailRequest request) {
        orderDetailRepository.saveOrderDetail(request.getOrderCode(),
                request.getPaymentTime(),
                request.getPaymentMethod(),
                request.getTotalPrice(),
                request.getStudentId());
    }

    @Override
    @Transactional
    public void saveOrder(OrderRequest request) {
        // Find student
        Optional<Student> optionalStudent = studentRepository.findById(request.getStudentId());
        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("Cannot find student with ID: " + request.getStudentId());
        }
        Student student = optionalStudent.get();

        // Create OrderDetail
        OrderDetail orderDetail = OrderDetail.builder()
                .orderCode(request.getOrderCode())
                .paymentTime(new Date())
                .paymentMethod(request.getPayMethod())
                .totalPrice(0) // Set to initial value
                .student(student)
                .build();
        orderDetailRepository.save(orderDetail);

        // Iterate through course IDs
        for (String courseId : request.getCourseId()) {
            // Find course
            Optional<Course> optionalCourse = courseRepository.findByCourseId(courseId);
            if (optionalCourse.isEmpty()) {
                throw new RuntimeException("Cannot find course with ID: " + courseId);
            }
            Course course = optionalCourse.get();

            // Create Order
            Order order = Order.builder()
                    .id(new OrderID(course,orderDetail))
                    .price(course.getPrice())
                    .build();
            orderRepository.save(order);
        }
    }
}
