package com.institution.college.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ra")
    private Long ra;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private String birthDate;

    @Column(name = "cpf")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "semester")
    private Integer semester;
}
