package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;

    private Integer creditPoints;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Speciality specialty;
}
