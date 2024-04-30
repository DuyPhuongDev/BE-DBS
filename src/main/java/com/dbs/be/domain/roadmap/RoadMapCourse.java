package com.dbs.be.domain.roadmap;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RoadMapCourseId.class)
@Entity
@Table(name = "Roadmap_course")
public class RoadMapCourse {
    @Id
    @ManyToOne
    @JoinColumn(name = "Course_id")
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "Roadmap_id")
    private RoadMap roadMap;

    @Column(name = "STT_course")
    private int Stt;
}
