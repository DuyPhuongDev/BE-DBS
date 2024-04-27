package com.dbs.be.rest.response;

import com.dbs.be.dto.LecturerDTO;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LecturerResponse {
    private String lecturerId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String gender;
    private Date bdate;
    private String addr;
    private String degree;
    private String major;

    public static LecturerResponse toResponse(LecturerDTO lecturerDTO){
        return LecturerResponse.builder()
                .lecturerId(lecturerDTO.getLecturerId())
                .userName(lecturerDTO.getUserName())
                .password(lecturerDTO.getPassword())
                .email(lecturerDTO.getEmail())
                .fullName(lecturerDTO.getFullName())
                .phoneNumber(lecturerDTO.getPhoneNumber())
                .gender(lecturerDTO.getGender())
                .bdate(lecturerDTO.getBdate())
                .addr(lecturerDTO.getAddr())
                .degree(lecturerDTO.getDegree())
                .major(lecturerDTO.getMajor())
                .build();
    }
}
