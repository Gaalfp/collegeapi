package com.institution.college.service;

import com.institution.college.dto.StudentDTO;
import com.institution.college.dto.StudentRequest;
import com.institution.college.model.Student;
import com.institution.college.repository.StudentRepository;
import com.institution.college.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    public Student addStudent(StudentRequest studentRequest) {
        Student student = Mapper.convertStudentRequestToStudent(studentRequest, courseService.findByDescription(studentRequest.getCourse()));
        if (existsByCpf(student.getCpf())) {
            return null;
        }
        return studentRepository.save(student);
    }

    private boolean existsByCpf(String cpf) {
        return studentRepository.existsByCpf(cpf);
    }




    public Student findByRa(Long ra) {
        return studentRepository.findByRa(ra);

    }

    @Transactional
    public void deletebyRa(Long ra) {
        studentRepository.deleteByRa(ra);
    }

    public Student updateStudent(StudentDTO studentRequest) {
        Student student = Mapper.convertStudentDTOToStudent(studentRequest, courseService.findByDescription(studentRequest.getCourse()));
        return studentRepository.save(student);
    }
}
