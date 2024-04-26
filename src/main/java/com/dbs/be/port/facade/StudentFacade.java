package com.dbs.be.port.facade;

import com.dbs.be.rest.response.StudentResponse;

import java.util.List;

public interface StudentFacade {
    List<StudentResponse> getAllStudents();
}
