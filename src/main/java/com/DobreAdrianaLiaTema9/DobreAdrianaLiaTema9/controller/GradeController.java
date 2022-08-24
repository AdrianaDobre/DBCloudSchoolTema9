package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.controller;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Grade;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("grade")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/createGrade")
    public Grade createGrade(@RequestBody Grade grade){
        return gradeService.createGrade(grade);
    }

    @GetMapping("/getAll")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }
}
