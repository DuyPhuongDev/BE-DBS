package com.dbs.be.port.facade;

import com.dbs.be.rest.request.CourseRequest;
import com.dbs.be.rest.response.CourseResponse;

import java.util.List;

public interface CourseFacade {
    void saveCourse(CourseRequest request);
    void updateCourse(String courseId, CourseRequest request);
    void deleteCourse(String courseId);

    List<CourseResponse> getAll();

    List<CourseResponse> searchCourseByCriteria(String lecturerId, String requiredLevel, Double priceS, Double priceE, Double progressS, Double progressE, String sortBy);
}