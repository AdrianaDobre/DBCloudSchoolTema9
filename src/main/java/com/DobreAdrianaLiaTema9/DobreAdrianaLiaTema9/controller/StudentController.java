package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.controller;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoGradeException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoSpecialityException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.NoStudentException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Grade;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service.StudentService;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.StudentListEmptyException;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getGradesBy/{studentId}")
    public List<Grade> getAllGradesOfStudent(@PathVariable Integer studentId) throws NoStudentException {
        return studentService.getAllGradesOfStudent(studentId);
    }

    @GetMapping("/getWithGradeGrater8")
    public List<Student> getAllStudentsWithGradeGreaterThanEight(){
        return studentService.getAllStudentsWithGradeGreaterThanEight();
    }

    @PostMapping("/addGrade/{studentId}/{gradeId}")
    public void addGrade(@PathVariable Integer studentId, @PathVariable Integer gradeId) throws NoStudentException, NoGradeException {
        studentService.addGrade(studentId,gradeId);
    }

    @PostMapping("/addSpeciality/{studentId}/{specialityId}")
    public void addSpecialty(@PathVariable Integer studentId,@PathVariable Integer specialityId) throws NoSpecialityException, NoStudentException {
        studentService.addSpecialty(studentId,specialityId);
    }

    @GetMapping("/getWithMaxAverage")
    public Student getWithMaxAverage() throws StudentListEmptyException {
        return studentService.getWithMaxAverage();
    }
}
