package com.dbs.be.port.facade;

import com.dbs.be.rest.request.UpsertLecturerRequest;
import com.dbs.be.rest.response.LecturerResponse;

import java.util.List;

public interface LecturerFacade {
    List<LecturerResponse> getAllLecturerSortByName();
    void saveLecturer(UpsertLecturerRequest request);
    void deleteLecturer(String lecturerId);
}
