package com.dbs.be.port.repository;

import com.dbs.be.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("SELECT c FROM Course c JOIN StudentCourse sc ON c.courseId=sc.course.courseId WHERE sc.student.id=:studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") String studentId);

    Optional<Course> findByCourseId(String courseId);
}
