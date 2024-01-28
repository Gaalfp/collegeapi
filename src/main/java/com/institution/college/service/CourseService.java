package com.institution.college.service;

import com.institution.college.dto.CourseDTO;
import com.institution.college.model.Course;
import com.institution.college.repository.CourseRepository;
import com.institution.college.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(CourseDTO courseRequest) {
        Course course = Mapper.convertToCourse(courseRequest);
        if (existsByDescription(courseRequest.getDescription())){
            return null;
        }
        return courseRepository.save(course);
    }

    private boolean existsByDescription(String description) {
        return courseRepository.existsByDescription(description);
    }

    public Course findByDescription(String name) {
        return (courseRepository.findByDescription(name).isPresent()) ? courseRepository.findByDescription(name).get() : null;
    }

    public List<Course> findByArea(String area) {
        return courseRepository.findAllByArea(area);
    }
}
