package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany
    private List<Student> students;

    @OneToMany
    private List<Course> courses;

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}
