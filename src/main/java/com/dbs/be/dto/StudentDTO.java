package com.dbs.be.dto;

import com.dbs.be.domain.user.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String studentId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String gender;
    private Date bdate;
    private String addr;
    private List<OrderDetailDTO> orderDetails;
    private List<StudentCourseDTO> studentCourses;

    public static StudentDTO fromDomain(Student student){
        return StudentDTO.builder()
                .studentId(student.getId())
                .userName(student.getFullName())
                .password(student.getPassword())
                .email(student.getEmail())
                .fullName(student.getFullName())
                .phoneNumber(student.getPhoneNumber())
                .gender(student.getGender())
                .bdate(student.getBdate())
                .addr(student.getAddr())
                .orderDetails(student.getOrderDetails().stream().map(OrderDetailDTO::fromDomain).collect(Collectors.toList()))
                .studentCourses(student.getStudentCourses().stream().map(StudentCourseDTO::fromDomain).collect(Collectors.toList()))
                .build();
    }
}
