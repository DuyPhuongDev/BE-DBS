package com.dbs.be.dto;

import com.dbs.be.domain.user.Lecturer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDTO {
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

    public static LecturerDTO fromDomain(Lecturer lecturer){
        return LecturerDTO.builder()
                .lecturerId(lecturer.getId())
                .userName(lecturer.getUsername())
                .password(lecturer.getPassword())
                .email(lecturer.getEmail())
                .fullName(lecturer.getFullName())
                .phoneNumber(lecturer.getPhoneNumber())
                .gender(lecturer.getGender())
                .bdate(lecturer.getBdate())
                .addr(lecturer.getAddr())
                .degree(lecturer.getDegree())
                .major(lecturer.getMajor())
                .build();
    }
}
