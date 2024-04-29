package com.dbs.be.domain.course;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CourseLanguageKey implements Serializable {
    private String language;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
