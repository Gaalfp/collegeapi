package com.institution.college.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @NotEmpty(message = "Course ID cannot be empty")
    private String description;

    @NotEmpty(message = "Course Area cannot be empty")
    private String area;
}
