package com.dbs.be.port.repository;

import com.dbs.be.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, String> {
    @Procedure(procedureName = "insert_user")
    void insertUser(@Param("id") String id,
                       @Param("username") String username,
                       @Param("email") String email,
                       @Param("phoneNumber") String phone,
                       @Param("pass") String pass,
                       @Param("role") String role,
                       @Param("fullname") String fullname,
                       @Param("gender") String gender,
                       @Param("bdate") Date bdate,
                       @Param("addr") String addr,
                       @Param("degree") String degree,
                       @Param("major") String major);

    @Procedure(procedureName = "delete_user")
    void deleteUser(@Param("id")String id);

    @Procedure(procedureName = "update_user")
    void updateUser(@Param("id") String id,
                    @Param("new_username") String username,
                    @Param("new_email") String email,
                    @Param("new_phoneNumber") String phone,
                    @Param("new_pass") String pass,
                    @Param("new_fullname") String fullname,
                    @Param("new_gender") String gender,
                    @Param("new_bdate") Date bdate,
                    @Param("new_addr") String addr,
                    @Param("new_degree") String degree,
                    @Param("new_major") String major,
                    @Param("role") String role);
}