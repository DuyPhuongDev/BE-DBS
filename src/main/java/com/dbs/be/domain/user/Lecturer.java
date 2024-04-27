package com.dbs.be.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "lecturer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer extends User{
    private String degree;
    private String major;

    public Lecturer(String id, String username, String password, String email, String phoneNumber, String fullName, String gender, Date bdate, String addr, String degree, String major) {
        super(id, username, password, email, phoneNumber, fullName, gender, bdate, addr);
        this.degree = degree;
        this.major = major;
    }
}
