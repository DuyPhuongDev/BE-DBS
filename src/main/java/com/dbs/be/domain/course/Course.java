package com.dbs.be.domain.course;

import com.dbs.be.domain.order.Order;
import com.dbs.be.domain.section.Section;
import com.dbs.be.domain.studentCourse.StudentCourse;
import com.dbs.be.domain.user.Lecturer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Course {
    @Id
    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "topic")
    private String topic;

    @Column(name = "required_level")
    private String requiredLevel;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ID_lecturer")
    private Lecturer lecturer;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseLanguage> courseLanguages;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Section> sections;
}
