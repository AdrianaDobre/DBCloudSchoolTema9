package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Course> courses;

    @OneToMany
    private List<Project> projects;

    private String firstName;

    private String lastName;

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}
