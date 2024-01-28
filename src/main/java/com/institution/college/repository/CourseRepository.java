package com.institution.college.repository;

import com.institution.college.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {


    Optional<Course> findByDescription(String description);

    boolean existsByDescription(String description);

    List<Course> findAllByArea(String area);
}
