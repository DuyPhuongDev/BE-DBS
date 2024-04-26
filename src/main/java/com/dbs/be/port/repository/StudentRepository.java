package com.dbs.be.port.repository;

import com.dbs.be.domain.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
}
