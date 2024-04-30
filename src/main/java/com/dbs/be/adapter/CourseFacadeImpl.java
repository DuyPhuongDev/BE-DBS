package com.dbs.be.adapter;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.course.CourseLanguage;
import com.dbs.be.domain.user.Lecturer;
import com.dbs.be.dto.CourseDTO;
import com.dbs.be.port.facade.CourseFacade;
import com.dbs.be.port.repository.CourseLanguageRepository;
import com.dbs.be.port.repository.CourseRepository;
import com.dbs.be.port.repository.LecturerRepository;
import com.dbs.be.rest.request.CourseRequest;
import com.dbs.be.rest.response.CourseResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseFacadeImpl implements CourseFacade {
    private final LecturerRepository lecturerRepository;
    private final CourseRepository courseRepository;
    private final CourseLanguageRepository courseLanguageRepository;
    @Override
    @Transactional
    public void saveCourse(CourseRequest request) {
        // Create Course entity
        Course course = new Course();
        course.setCourseId(request.getCourseId());
        course.setCourseName(request.getCourseName());
        course.setDescription(request.getDescription());
        course.setTopic(request.getTopic());
        course.setRequiredLevel(request.getRequiredLevel());
        course.setPrice(request.getPrice());

        // Retrieve Lecturer entity
        course.setLecturer(lecturerRepository.findById(request.getLecturerId()).orElse(null));

        // Save Course entity
        course = courseRepository.save(course);

        // Create and save CourseLanguage entities
        List<CourseLanguage> courseLanguages = new ArrayList<>();
        for (String language : request.getLanguages()) {
            CourseLanguage courseLanguage = new CourseLanguage();
            courseLanguage.setLanguage(language);
            courseLanguage.setCourse(course);
            courseLanguages.add(courseLanguage);
        }
        courseLanguageRepository.saveAll(courseLanguages);
    }

    @Override
    @Transactional
    public void updateCourse(String courseId, CourseRequest request) {
        // Retrieve the existing Course entity
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();

            // Update the Course entity fields
            course.setCourseName(request.getCourseName());
            course.setDescription(request.getDescription());
            course.setTopic(request.getTopic());
            course.setRequiredLevel(request.getRequiredLevel());
            course.setPrice(request.getPrice());

            // Retrieve the associated Lecturer entity
            course.setLecturer(lecturerRepository.findById(request.getLecturerId()).orElse(null));

            // Save the updated Course entity
            courseRepository.save(course);

            // Update CourseLanguage entities
            List<String> newLanguages = request.getLanguages();

            // Get the existing CourseLanguage entities for the Course
            List<CourseLanguage> existingLanguages = courseLanguageRepository.findByCourse(course);

            // Remove CourseLanguage entities not present in the request
            List<CourseLanguage> languagesToRemove = existingLanguages.stream()
                    .filter(language -> !newLanguages.contains(language.getLanguage()))
                    .collect(Collectors.toList());
            courseLanguageRepository.deleteAll(languagesToRemove);

            // Add new CourseLanguage entities
            for (String language : newLanguages) {
                if (existingLanguages.stream().noneMatch(cl -> cl.getLanguage().equals(language))) {
                    CourseLanguage newLanguage = new CourseLanguage();
                    newLanguage.setLanguage(language);
                    newLanguage.setCourse(course);
                    courseLanguageRepository.save(newLanguage);
                }
            }
        } else {
            // Handle the case where the course with the given courseId does not exist
            throw new RuntimeException("Course cannot found!");
        }
    }

    @Override
    @Transactional
    public void deleteCourse(String courseId) {
        // Delete the course by courseId
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<CourseResponse> getAll() {
        // Retrieve all courses from the database
        List<Course> courses = courseRepository.findAll();

        // Convert the list of courses to a list of CourseResponse objects

        return courses.stream().map(CourseDTO::fromDomain)
                .map(CourseResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseResponse> searchCourseByCriteria(String lecturerId, String requiredLevel, Double priceS, Double priceE, Double progressS, Double progressE, String sortBy) {
        List<Course> courses = courseRepository.findCoursesByCriteriaAndSort(lecturerId,requiredLevel,priceS,priceE,progressS,progressE,sortBy);
        if(courses.isEmpty()) throw new RuntimeException("cannot found");
        return courses.stream().map(CourseDTO::fromDomain)
                .map(CourseResponse::toResponse)
                .collect(Collectors.toList());
    }

}
