package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoCourseException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoProfessorException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Professor;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.CourseRepository;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.ProfessorRepository;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public Professor createProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    public List<Course> getAllCoursesOfProfessor(Integer professorId) throws NoProfessorException {
        Professor professor = professorRepository.findById(professorId).orElseThrow(NoProfessorException::new);
        return professor.getCourses();
    }

    public void addCourse(Integer professorId, Integer courseId) throws NoProfessorException, NoCourseException {
        Professor professor = professorRepository.findById(professorId).orElseThrow(NoProfessorException::new);
        Course course = courseRepository.findById(courseId).orElseThrow(NoCourseException::new);
        professor.addCourse(course);
        professorRepository.save(professor);
    }
}
