package com.institution.college.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Pattern(regexp = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$", message = "Invalid date")
    private String birthDate;

    @NotBlank(message = "Invalid CPF")
    private String cpf;

    @NotBlank(message = "Course cannot be blank")
    private String course;

    @NotBlank(message = "Semester cannot be blank")
    private Integer semester;
}