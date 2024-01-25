package com.institution.college.service;

import com.institution.college.model.Course;
import com.institution.college.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
