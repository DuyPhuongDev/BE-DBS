package com.dbs.be.rest.controller;

import com.dbs.be.domain.user.Student;
import com.dbs.be.domain.user.User;
import com.dbs.be.port.facade.StudentFacade;
import com.dbs.be.port.facade.UserFacade;
import com.dbs.be.rest.response.BaseResponse;
import com.dbs.be.rest.response.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class UserController {
   private final UserFacade userFacade;
   private final StudentFacade studentFacade;
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "User APIs")
    public EntityResponse<User> getUser(@PathVariable String id){
        return EntityResponse.fromObject(userFacade.getUser(id)).build();
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "User APIs")
    public List<User> getAllUses(){
        return userFacade.getAll();
    }

    @GetMapping("/students")
    @Operation(tags = "User APIs")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<StudentResponse>> getAllStudents(){
        return BaseResponse.of(studentFacade.getAllStudents());
    }
}
