package com.dbs.be.domain.section;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SectionId implements Serializable {
    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
