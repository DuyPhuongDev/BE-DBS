package com.dbs.be.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class CourseRequest extends BaseRequest{
    private String courseId;
    private String courseName;
    private String description;
    private String topic;
    private String requiredLevel;
    private Double price;
    private String lecturerId;
    private List<String> languages;
}
