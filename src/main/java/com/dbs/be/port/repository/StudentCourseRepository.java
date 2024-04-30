package com.dbs.be.port.repository;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.studentCourse.StudentCourse;
import com.dbs.be.domain.studentCourse.StudentCourseId;
import com.dbs.be.domain.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
    void deleteStudentCourseByCourseAndStudent(Course course, Student student);
    List<StudentCourse> findStudentCoursesByStudentId(String studentId);
}
