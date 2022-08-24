package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.GradeListEmptyException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    private List<Grade> grades;

    @ManyToOne
    private Speciality specialty;

    public Integer calculateAnnualAverageGrade() throws GradeListEmptyException {
        if (this.grades.isEmpty()) {
            throw new GradeListEmptyException();
        } else {
            Integer averageGrade = 0;
            for (Grade grade : this.grades)
                averageGrade += grade.getGrade();
            return averageGrade / this.grades.size();
        }
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }
}
