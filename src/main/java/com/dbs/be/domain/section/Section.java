package com.dbs.be.domain.section;

import com.dbs.be.domain.course.Course;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "section")
@IdClass(SectionId.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Section {
    @Id
    private String title;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
