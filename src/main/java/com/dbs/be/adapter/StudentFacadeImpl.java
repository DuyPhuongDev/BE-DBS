package com.dbs.be.adapter;

import com.dbs.be.domain.user.Student;
import com.dbs.be.dto.StudentDTO;
import com.dbs.be.port.facade.StudentFacade;
import com.dbs.be.port.repository.StudentRepository;
import com.dbs.be.rest.request.UpsertStudentRequest;
import com.dbs.be.rest.response.StudentResponse;
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
    @Override
    public List<StudentResponse> getAllStudents() {

        List<Student> students = studentRepository.findAllByOrderByFullNameAsc();
        if(students.isEmpty()) return new ArrayList<>();
        return students.stream().map(StudentDTO::fromDomain).map(StudentResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public void saveStudent(UpsertStudentRequest request) {
        Student student = (Student) Student.builder()
                .id(request.getStudentId())
                .username(request.getUserName())
                .password(request.getPassword())
                .email(request.getEmail())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .bdate(request.getBdate())
                .addr(request.getAddr())
                .build();
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            studentRepository.deleteById(studentId);
        }else throw new RuntimeException("Student cannot found!\n");
    }
}
