package com.dbs.be.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseInfo {
    @Id
    private String courseId;
    private String courseName;
    @Column(name = "num_of_student")
    private int studentCount;
    private double totalPrice;

    // Constructors, getters, and setters
}