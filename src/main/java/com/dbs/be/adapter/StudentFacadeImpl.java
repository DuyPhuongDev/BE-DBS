package com.dbs.be.adapter;

import com.dbs.be.domain.user.Student;
import com.dbs.be.dto.StudentDTO;
import com.dbs.be.port.facade.StudentFacade;
import com.dbs.be.port.repository.StudentRepository;
import com.dbs.be.rest.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentFacadeImpl implements StudentFacade {
    private final StudentRepository studentRepository;
    @Override
    public List<StudentResponse> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentDTO::fromDomain).map(StudentResponse::toResponse).collect(Collectors.toList());
    }
}
