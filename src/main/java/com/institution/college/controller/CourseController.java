package com.institution.college.controller;

import com.institution.college.model.Course;
import com.institution.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        return null;
    }
}
