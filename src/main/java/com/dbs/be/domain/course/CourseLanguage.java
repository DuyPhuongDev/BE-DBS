package com.dbs.be.domain.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@IdClass(CourseLanguageKey.class)
@Table(name = "course_language")
public class CourseLanguage {

    @Id
    @Column(name = "language", length = 10)
    private String language;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Constructors, getters, and setters
}