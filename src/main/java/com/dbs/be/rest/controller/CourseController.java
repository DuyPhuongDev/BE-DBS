package com.dbs.be.rest.controller;

import com.dbs.be.port.facade.CourseFacade;
import com.dbs.be.rest.request.CourseRequest;
import com.dbs.be.rest.response.BaseResponse;
import com.dbs.be.rest.response.CourseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseFacade courseFacade;

    @PostMapping("/create-course")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(tags = "Course APIs")
    public BaseResponse<Void> createCourse(@RequestBody CourseRequest request){
        courseFacade.saveCourse(request);
        return BaseResponse.empty();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Course APIs")
    public BaseResponse<List<CourseResponse>> getAllCourse(){
        return BaseResponse.of(courseFacade.getAll());
    }

    @PutMapping("/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Course APIs")
    public BaseResponse<Void> updateCourse(@PathVariable String courseId, @RequestBody CourseRequest request){
        courseFacade.updateCourse(courseId,request);
        return BaseResponse.empty();
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Course APIs")
    public BaseResponse<Void> deleteCourse(@PathVariable String courseId){
        courseFacade.deleteCourse(courseId);
        return BaseResponse.empty();
    }

}
