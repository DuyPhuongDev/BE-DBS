package com.dbs.be.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertLecturerRequest extends BaseRequest{
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
}
