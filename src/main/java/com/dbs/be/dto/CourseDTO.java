package com.dbs.be.dto;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.course.CourseLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String courseId;
    private String courseName;
    private String description;
    private String topic;
    private String requiredLevel;
    private Double price;
    private String lecturerId;
    private List<String> languages;
    private List<StudentCourseDTO> studentCourses;

    public static CourseDTO fromDomain(Course course){
        return CourseDTO.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .requiredLevel(course.getRequiredLevel())
                .topic(course.getTopic())
                .price(course.getPrice())
                .lecturerId(course.getLecturer().getId())
                .languages(course.getCourseLanguages().stream().map(CourseLanguage::getLanguage).collect(Collectors.toList()))
                .studentCourses(course.getStudentCourses().stream().map(StudentCourseDTO::fromDomain).collect(Collectors.toList()))
                .build();
    }
}
