package com.dbs.be.port.facade;

import com.dbs.be.rest.request.UpsertStudentRequest;
import com.dbs.be.rest.response.CourseResponse;
import com.dbs.be.rest.response.StudentResponse;

import java.util.List;

public interface StudentFacade {
    List<StudentResponse> getAllStudents();

    void saveStudent(UpsertStudentRequest request);

    void updateStudent(String studentId, UpsertStudentRequest request);

    void deleteStudent(String studentId);

    List<CourseResponse> findCoursesByStudentId(String studentId);

    void deleteCourse(String courseId, String studentId);


    List<StudentResponse> searchAllStudents(String name, String courseId);

    List<CourseResponse> searchCourseByCriteria(String studentId, String lecturerId, String requiredLevel, Double priceS, Double priceE, Double progressS, Double progressE, String sortBy);
}
