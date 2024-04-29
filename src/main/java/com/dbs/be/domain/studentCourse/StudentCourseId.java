package com.dbs.be.domain.studentCourse;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.user.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class StudentCourseId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors, equals, and hashCode methods
}