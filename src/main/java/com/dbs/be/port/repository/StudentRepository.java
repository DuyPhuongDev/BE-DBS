package com.dbs.be.port.repository;

import com.dbs.be.domain.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByOrderByFullNameAsc();
    @Query("SELECT DISTINCT s FROM Student s " +
            "LEFT JOIN s.studentCourses sc " +
            "WHERE (:name IS NULL OR s.fullName LIKE %:name%) " +
            "AND (:courseId IS NULL OR sc.course.courseId LIKE %:courseId%)")
    List<Student> findStudentsByNameOrCourseId(@Param("name") String name,
                                               @Param("courseId") String courseId);

}
