package com.dbs.be.domain.studentCourse;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.user.Student;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_course")
@IdClass(StudentCourseId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentCourse {

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "progress", nullable = false)
    private Double progress;

    // Constructors, getters, and setters
}