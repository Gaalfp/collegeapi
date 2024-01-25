package com.institution.college.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    private Long ra;

    private String name;

    private String birthDate;

    private String cpf;

    private String course;

    private Integer semester;
}