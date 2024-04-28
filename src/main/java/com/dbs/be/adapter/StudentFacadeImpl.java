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
        Student student = new Student(
                request.getStudentId(),
                request.getUserName(),
                request.getPassword(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getFullName(),
                request.getGender(),
                request.getBdate(),
                request.getAddr()
        );
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(String studentId, UpsertStudentRequest request) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            if (request.getUserName()!=null) student.setUsername(request.getUserName());
            if(request.getPassword()!=null) student.setPassword(request.getPassword());
            if(request.getEmail()!=null) student.setEmail(request.getEmail());
            if(request.getPhoneNumber()!=null) student.setPhoneNumber(request.getPhoneNumber());
            if(request.getFullName()!=null) student.setFullName(request.getFullName());
            if(request.getGender()!=null) student.setGender(request.getGender());
            if(request.getBdate()!=null) student.setBdate(request.getBdate());
            if(request.getAddr()!=null) student.setAddr(request.getAddr());
            studentRepository.save(student);
        }else throw new RuntimeException("student not found!\n");
    }

    @Override
    public void deleteStudent(String studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            studentRepository.deleteById(studentId);
        }else throw new RuntimeException("Student cannot found!\n");
    }
}
