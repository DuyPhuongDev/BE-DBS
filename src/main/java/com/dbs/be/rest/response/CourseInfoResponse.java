package com.dbs.be.rest.response;

import com.dbs.be.dto.CourseInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CourseInfoResponse {
    private String courseId;
    private String courseName;
    private int studentCount;
    private double totalPrice;

    public static CourseInfoResponse toResponse(CourseInfoDTO courseInfoDTO){
        return CourseInfoResponse.builder()
                .courseId(courseInfoDTO.getCourseId())
                .courseName(courseInfoDTO.getCourseName())
                .studentCount(courseInfoDTO.getStudentCount())
                .totalPrice(courseInfoDTO.getTotalPrice())
                .build();
    }
}
