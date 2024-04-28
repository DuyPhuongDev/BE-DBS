package com.dbs.be.port.facade;

import com.dbs.be.rest.request.UpsertStudentRequest;
import com.dbs.be.rest.response.StudentResponse;

import java.util.List;

public interface StudentFacade {
    List<StudentResponse> getAllStudents();

    void saveStudent(UpsertStudentRequest request);

    void updateStudent(String studentId, UpsertStudentRequest request);

    void deleteStudent(String studentId);
}
