package com.dbs.be.port.repository;

import com.dbs.be.domain.user.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, String> {
    List<Lecturer> findAllByOrderByFullNameAsc();
    Optional<Lecturer> findLecturerById(String id);
}
