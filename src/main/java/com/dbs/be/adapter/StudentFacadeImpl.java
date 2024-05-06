package com.dbs.be.adapter;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.user.Student;
import com.dbs.be.dto.CourseDTO;
import com.dbs.be.dto.StudentDTO;
import com.dbs.be.port.facade.StudentFacade;
import com.dbs.be.port.repository.CourseRepository;
import com.dbs.be.port.repository.StudentCourseRepository;
import com.dbs.be.port.repository.StudentRepository;
import com.dbs.be.port.repository.UserRepository;
import com.dbs.be.rest.request.UpsertStudentRequest;
import com.dbs.be.rest.response.CourseResponse;
import com.dbs.be.rest.response.StudentResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentFacadeImpl implements StudentFacade {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;
    private final UserRepository userRepository;
    @Override
    public List<StudentResponse> getAllStudents() {

        List<Student> students = studentRepository.findAllByOrderByFullNameAsc();
        if(students.isEmpty()) return new ArrayList<>();
        return students.stream().map(StudentDTO::fromDomain).map(StudentResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public void saveStudent(UpsertStudentRequest request) {
        userRepository.insertUser(
                request.getStudentId(),
                request.getUserName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getPassword(),
                "student",
                request.getFullName(),
                request.getGender(),
                request.getBdate(),
                request.getAddr(),
                null,
                null
        );
    }

    @Override
    public void updateStudent(String studentId, UpsertStudentRequest request) {
        userRepository.updateUser(
                request.getStudentId(),
                request.getUserName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getPassword(),
                request.getFullName(),
                request.getGender(),
                request.getBdate(),
                request.getAddr(),
                null,
                null,
                "student"
        );
    }

    @Override
    public void deleteStudent(String studentId) {
        userRepository.deleteUser(studentId);
    }

    @Override
    @Transactional
    public List<CourseResponse> findCoursesByStudentId(String studentId) {
        //List<Course> courses = courseRepository.findCoursesByStudentId(studentId);
        List<Course> courses = courseRepository.findCourseStudent(studentId);
        if (courses.isEmpty()) throw new RuntimeException("Course cannot found!");
        return courses.stream().map(CourseDTO::fromDomain).map(CourseResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteCourse(String courseId, String studentId) {
        Optional<Course> optionalCourse = courseRepository.findByCourseId(courseId);
        if(optionalCourse.isEmpty()) throw new RuntimeException("Course cannot found");
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isEmpty()) throw new RuntimeException("Student cannot found!");
        studentCourseRepository.deleteStudentCourseByCourseAndStudent(optionalCourse.get(),optionalStudent.get());
    }

    @Override
    public List<StudentResponse> searchAllStudents(String name, String courseId) {
        List<Student> students = studentRepository.findStudentsByNameOrCourseId(name, courseId);
        if (students.isEmpty()) throw new RuntimeException("cannot found");
        return students.stream().map(StudentDTO::fromDomain).map(StudentResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<CourseResponse> searchCourseByCriteria(String studentId, String lecturerId, String requiredLevel, Double priceS, Double priceE, Double progressS, Double progressE, String sortBy) {
        List<Course> courses = courseRepository.findCoursesByCriteriaAndSort(studentId, lecturerId,requiredLevel,priceS,priceE,progressS,progressE,sortBy);
        if(courses.isEmpty()) throw new RuntimeException("cannot found");
        return courses.stream().map(CourseDTO::fromDomain)
                .map(CourseResponse::toResponse)
                .collect(Collectors.toList());
    }

}
