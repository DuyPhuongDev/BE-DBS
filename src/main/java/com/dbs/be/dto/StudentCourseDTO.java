package com.dbs.be.dto;

import com.dbs.be.domain.studentCourse.StudentCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourseDTO {
    private String studentId;
    private String courseId;
    private Double progress;

    public static StudentCourseDTO fromDomain(StudentCourse studentCourse){
        return StudentCourseDTO.builder()
                .studentId(studentCourse.getStudent().getId())
                .courseId(studentCourse.getCourse().getCourseId())
                .progress(studentCourse.getProgress())
                .build();
    }
}
