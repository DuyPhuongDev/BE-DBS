package com.dbs.be.rest.controller;

import com.dbs.be.port.facade.LecturerFacade;
import com.dbs.be.rest.request.UpsertLecturerRequest;
import com.dbs.be.rest.response.BaseResponse;
import com.dbs.be.rest.response.LecturerResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecturers")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerFacade lecturerFacade;
    @GetMapping("/")
    @Operation(tags = "Lecturer APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<LecturerResponse>> getAllLecturers(){
        return BaseResponse.of(lecturerFacade.getAllLecturerSortByName());
    }

    @PostMapping("/create-lecturer")
    @Operation(tags = "Lecturer APIs")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Void> creteLecturer(@RequestBody UpsertLecturerRequest request){
        lecturerFacade.saveLecturer(request);
        return BaseResponse.empty();
    }

    @DeleteMapping("/{lecturerId}")
    @Operation(tags = "Lecturer APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Void> deleteLecturer(@PathVariable String lecturerId){
        lecturerFacade.deleteLecturer(lecturerId);
        return BaseResponse.empty();
    }

    @PutMapping("/{lecturerId}")
    @Operation(tags = "Lecturer APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Void> updateLecturer(@PathVariable String lecturerId, @RequestBody UpsertLecturerRequest request){
        lecturerFacade.updateLecturer(lecturerId, request);
        return BaseResponse.empty();
    }
}
