package com.institution.college.repository;

import com.institution.college.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    boolean existsByCpf(@NonNull String cpf);

    Student findByRa(Long ra);

    void deleteByRa(Long ra);
}
