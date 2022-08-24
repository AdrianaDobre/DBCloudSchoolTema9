package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.controller;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoCourseException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoProfessorException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Professor;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Course;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping("/createProfessor")
    public Professor createProfessor(@RequestBody Professor professor){
        return professorService.createProfessor(professor);
    }

    @GetMapping("/getAll")
    public List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @GetMapping("/getCoursesBy/{professorId}")
    public List<Course> getAllCoursesOfProfessor(@PathVariable Integer professorId) throws NoProfessorException {
        return professorService.getAllCoursesOfProfessor(professorId);
    }

    @PostMapping("/addCourse/{professorId}/{courseId}")
    public void addCourse(@PathVariable Integer professorId,@PathVariable Integer courseId) throws NoProfessorException, NoCourseException {
        professorService.addCourse(professorId,courseId);
    }
}
