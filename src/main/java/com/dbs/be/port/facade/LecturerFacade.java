package com.dbs.be.port.facade;

import com.dbs.be.domain.view.CourseInfo;
import com.dbs.be.rest.request.UpsertLecturerRequest;
import com.dbs.be.rest.response.CourseInfoResponse;
import com.dbs.be.rest.response.LecturerResponse;

import java.util.List;

public interface LecturerFacade {
    List<LecturerResponse> getAllLecturerSortByName();
    void saveLecturer(UpsertLecturerRequest request);

    void updateLecturer(String lecturerId, UpsertLecturerRequest request);
    void deleteLecturer(String lecturerId);

    List<CourseInfoResponse> getCourse(String lecturerId);
}
