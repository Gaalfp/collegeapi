package com.institution.college.controller;


import com.institution.college.dto.ResponseDTO;
import com.institution.college.dto.StudentDTO;
import com.institution.college.dto.StudentRequest;
import com.institution.college.model.Student;
import com.institution.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addStudent(@RequestBody @Valid StudentRequest student) {
        Student studentResponse = studentService.addStudent(student);
        int statusCode = (studentResponse == null) ? 400 : 201;
        String message = (studentResponse == null) ? "Student already exists" : "Student added successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, studentResponse, new Date()));
    }

    @GetMapping("/getbyra")
    public ResponseEntity<ResponseDTO> getStudentByRa(@RequestParam Long ra) {
        Student student = studentService.findByRa(ra);
        int statusCode = (student == null) ? 400 : 200;
        String message = (student == null) ? "Student not found" : "Student found successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, student, new Date()));
    }

    @DeleteMapping("/deletebyra")
    public ResponseEntity<ResponseDTO> deleteStudentByRa(@RequestParam Long ra) {
        studentService.deletebyRa(ra);
        int statusCode = 200;
        String message = "Student deleted successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, null, new Date()));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateStudent(@RequestBody @Valid StudentDTO studentRequest) {
        Student student = studentService.updateStudent(studentRequest);
        int statusCode = (student == null) ? 400 : 200;
        String message = (student == null) ? "Student not found" : "Student updated successfully";
        return ResponseEntity.status(statusCode)
                .body(new ResponseDTO(statusCode, message, student, new Date()));
    }
}
