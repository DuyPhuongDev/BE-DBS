package com.dbs.be.dto;

import com.dbs.be.domain.view.CourseInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoDTO {
    private String courseId;
    private String courseName;
    private int studentCount;
    private double totalPrice;

    public static CourseInfoDTO fromDomain(CourseInfo courseInfo){
        return CourseInfoDTO.builder()
                .courseId(courseInfo.getCourseId())
                .courseName(courseInfo.getCourseName())
                .studentCount(courseInfo.getStudentCount())
                .totalPrice(courseInfo.getTotalPrice())
                .build();
    }
}
