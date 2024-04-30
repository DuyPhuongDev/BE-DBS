package com.dbs.be.domain.roadmap;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RoadMapCourseId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "Roadmap_id")
    private RoadMap roadMap;
}
