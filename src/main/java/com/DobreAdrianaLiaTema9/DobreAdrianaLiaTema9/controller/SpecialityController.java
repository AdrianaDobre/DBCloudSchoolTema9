package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.controller;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.*;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Speciality;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Student;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("speciality")
public class SpecialityController {
    private final SpecialityService specialityService;

    @PostMapping("/createSpeciality")
    public Speciality createSpeciality(@RequestBody Speciality speciality){
        return specialityService.createSpeciality(speciality);
    }

    @GetMapping("/getAll")
    public List<Speciality> getAllSpecialities(){
        return specialityService.getAllSpecialities();
    }

    @GetMapping("/getStudentsBy/{specialityId}")
    public List<Student> getStudentsOfSpeciality(@PathVariable Integer specialityId) throws NoSpecialityException {
        return specialityService.getStudentsOfSpeciality(specialityId);
    }

    @PostMapping("/addStudent/{specialityId}/{studentId}")
    public void addStudent(@PathVariable Integer specialityId,@PathVariable Integer studentId) throws NoSpecialityException, NoStudentException {
        specialityService.addStudent(specialityId,studentId);
    }

    @GetMapping("/getMaxWithStudents")
    public Speciality getWithMaxStudents() throws SpecialityListEmptyException {
        return specialityService.getWithMaxStudents();
    }

    @GetMapping("/calculateAverage/{specialityId}")
    public Integer calculateAverage(@PathVariable Integer specialityId) throws NoSpecialityException, GradeListEmptyException, StudentListEmptyException, NoGradeException {
        return specialityService.calculateAverage(specialityId);
    }

    @GetMapping("/getWithMaxAverage/{specialityId}")
    public Student getWithMaxAverage(@PathVariable Integer specialityId) throws NoSpecialityException, StudentListEmptyException {
        return specialityService.getWithMaxAverage(specialityId);
    }
}
