package com.dbs.be.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    @Column(name = "ID")
    protected String id;

    @Column(name = "Username", unique = true, nullable = false)
    protected String username;

    @Column(name = "Password",nullable = false)
    protected String password;

    @Column(name = "Email")
    protected String email;

    @Column(name = "SDT")
    protected String phoneNumber;

    @Column(name = "fullname")
    protected String fullName;

    @Column(name = "gender")
    protected String gender;

    @Column(name = "bdate")
    @Temporal(TemporalType.DATE)
    protected Date bdate;

    @Column(name = "addr")
    protected String addr;
}
