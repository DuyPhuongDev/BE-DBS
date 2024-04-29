package com.dbs.be.port.repository;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.course.CourseLanguage;
import com.dbs.be.domain.course.CourseLanguageKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseLanguageRepository extends JpaRepository<CourseLanguage, CourseLanguageKey> {
    List<CourseLanguage> findByCourse(Course course);
}
