package com.dbs.be.rest.controller;

import com.dbs.be.port.facade.StudentFacade;
import com.dbs.be.rest.request.UpsertStudentRequest;
import com.dbs.be.rest.response.BaseResponse;
import com.dbs.be.rest.response.CourseResponse;
import com.dbs.be.rest.response.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/students")
@RestController
public class StudentController {
   private final StudentFacade studentFacade;

    @GetMapping("/")
    @Operation(tags = "Student APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<StudentResponse>> getAllStudents(@RequestParam(defaultValue = "0") Boolean searchFlag,
                                                              @RequestParam(required = false) String name,
                                                              @RequestParam(required = false) String courseId){
        if(searchFlag==Boolean.TRUE){
            return BaseResponse.of(studentFacade.searchAllStudents(name,courseId));
        }
        return BaseResponse.of(studentFacade.getAllStudents());
    }

    @PostMapping("/create-student")
    @Operation(tags = "Student APIs")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Void> createStudent(@RequestBody UpsertStudentRequest request){
        studentFacade.saveStudent(request);
        return BaseResponse.empty();
    }

    @DeleteMapping("/{studentId}")
    @Operation(tags = "Student APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Void> deleteStudent(@PathVariable String studentId){
        studentFacade.deleteStudent(studentId);
        return BaseResponse.empty();
    }

    @PutMapping("/{studentId}")
    @Operation(tags = "Student APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Void> updateStudent(@PathVariable String studentId, @RequestBody UpsertStudentRequest request){
        studentFacade.updateStudent(studentId, request);
        return BaseResponse.empty();
    }

    @GetMapping("/{studentId}/courses")
    @Operation(tags = "Student APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<CourseResponse>> findAllCourses(@PathVariable String studentId,
                                                             @RequestParam(defaultValue = "0") Boolean searchFlag,
                                                             @RequestParam(required = false) String lecturerId,
                                                             @RequestParam(required = false) String requiredLevel,
                                                             @RequestParam(required = false) Double priceS,
                                                             @RequestParam(required = false) Double priceE,
                                                             @RequestParam(required = false) Double progressS,
                                                             @RequestParam(required = false) Double progressE,
                                                             @RequestParam(defaultValue = "ASC") String sortBy){
        if (searchFlag==Boolean.TRUE){
            return BaseResponse.of(studentFacade.searchCourseByCriteria(studentId,lecturerId,requiredLevel,priceS,priceE,progressS,progressE,sortBy));
        }
        return BaseResponse.of(studentFacade.findCoursesByStudentId(studentId));
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    @Operation(tags = "Student APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Void> deleteStudentCourse(@PathVariable String studentId, @PathVariable String courseId){
        studentFacade.deleteCourse(courseId, studentId);
        return BaseResponse.empty();
    }
}
