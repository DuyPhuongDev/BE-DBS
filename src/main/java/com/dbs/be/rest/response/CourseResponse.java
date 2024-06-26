package com.dbs.be.rest.response;

import com.dbs.be.dto.CourseDTO;
import com.dbs.be.dto.StudentCourseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String courseId;
    private String courseName;
    private String description;
    private String topic;
    private String requiredLevel;
    private Double price;
    private String lecturerId;
    private List<String> languages;
    private List<StudentCourseDTO> studentCourses;

    public static CourseResponse toResponse(CourseDTO courseDTO){
        return CourseResponse.builder()
                .courseId(courseDTO.getCourseId())
                .courseName(courseDTO.getCourseName())
                .description(courseDTO.getDescription())
                .topic(courseDTO.getTopic())
                .requiredLevel(courseDTO.getRequiredLevel())
                .price(courseDTO.getPrice())
                .lecturerId(courseDTO.getLecturerId())
                .languages(courseDTO.getLanguages())
                .studentCourses(courseDTO.getStudentCourses())
                .build();
    }
}
