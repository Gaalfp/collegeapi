package com.institution.college.utils;

import com.institution.college.dto.CourseDTO;
import com.institution.college.dto.StudentDTO;
import com.institution.college.dto.StudentRequest;
import com.institution.college.model.Course;
import com.institution.college.model.Student;

public class Mapper{

    private Mapper() {
    }
    public static Student convertStudentRequestToStudent(StudentRequest input, Course course) {
        return new Student(null, input.getName(), input.getBirthDate(), input.getCpf(), course, input.getSemester());
    }


    public static Student convertStudentDTOToStudent(StudentDTO input, Course course) {
        return new Student(input.getRa(), input.getName(), input.getBirthDate(), input.getCpf(), course, input.getSemester());
    }


    public static Course convertToCourse(CourseDTO input) {
        return new Course(null, input.getDescription(), input.getArea());
    }
}
