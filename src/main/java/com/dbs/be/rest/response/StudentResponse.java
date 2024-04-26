package com.dbs.be.rest.response;

import com.dbs.be.dto.OrderDetailDTO;
import com.dbs.be.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String studentId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String gender;
    private Date bdate;
    private String addr;
    private List<OrderDetailDTO> orderDetails;

    public static StudentResponse toResponse(StudentDTO studentDTO){
        return StudentResponse.builder()
                .studentId(studentDTO.getStudentId())
                .userName(studentDTO.getUserName())
                .password(studentDTO.getPassword())
                .email(studentDTO.getEmail())
                .fullName(studentDTO.getFullName())
                .gender(studentDTO.getGender())
                .bdate(studentDTO.getBdate())
                .addr(studentDTO.getAddr())
                .orderDetails(studentDTO.getOrderDetails())
                .build();
    }
}
