package com.institution.college.controller;

import com.institution.college.dto.CourseDTO;
import com.institution.college.dto.ResponseDTO;
import com.institution.college.model.Course;
import com.institution.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addCourse(@RequestBody @Valid CourseDTO courseRequest) {
        Course course = courseService.saveCourse(courseRequest);
        int statusCode = (course == null) ? 400 : 201;
        String message = (course == null) ? "Course already exists" : "Course added successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, course, new Date()));

    }

    @GetMapping("/getbydescription")
    public ResponseEntity<ResponseDTO> getCourseByDescription(@RequestParam String description) {
        Course course = courseService.findByDescription(description);
        int statusCode = (course == null) ? 400 : 200;
        String message = (course == null) ? "Course not found" : "Course found successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, course, new Date()));
    }

    @GetMapping("/getbyarea")
    public ResponseEntity<ResponseDTO> getCoursesByArea(@RequestParam String area) {
        List<Course> course = courseService.findByArea(area);
        int statusCode = (course.isEmpty()) ? 400 : 200;
        String message = (course.isEmpty()) ? "Courses not found" : "Courses found successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, course, new Date()));
    }



}
