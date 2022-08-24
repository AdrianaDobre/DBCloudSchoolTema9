package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.*;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.GradeRepository;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.SpecialityRepository;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Grade;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Speciality;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Student;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final SpecialityRepository specialityRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Grade> getAllGradesOfStudent(Integer studentId) throws NoStudentException {
        Student student = studentRepository.findById(studentId).orElseThrow(NoStudentException::new);
        return student.getGrades();
    }

    public List<Student> getAllStudentsWithGradeGreaterThanEight() {
        return studentRepository.findAll().stream().filter((Student student) -> {
            try {
                return student.calculateAnnualAverageGrade() > 8;
            } catch (GradeListEmptyException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    public void addGrade(Integer studentId, Integer gradeId) throws NoStudentException, NoGradeException {
        Student student = studentRepository.findById(studentId).orElseThrow(NoStudentException::new);
        Grade grade = gradeRepository.findById(gradeId).orElseThrow(NoGradeException::new);
        student.addGrade(grade);
        studentRepository.save(student);
    }

    public void addSpecialty(Integer studentId, Integer specialityId) throws NoStudentException, NoSpecialityException {
        Student student = studentRepository.findById(studentId).orElseThrow(NoStudentException::new);
        Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(NoSpecialityException::new);
        student.setSpecialty(speciality);
        studentRepository.save(student);
    }

    public Student getWithMaxAverage() throws StudentListEmptyException {
        return studentRepository.findAll().stream().max(Comparator.comparing(student -> {
            try {
                return student.calculateAnnualAverageGrade();
            } catch (GradeListEmptyException e) {
                throw new RuntimeException(e);
            }
        })).orElseThrow(StudentListEmptyException::new);
    }
}
