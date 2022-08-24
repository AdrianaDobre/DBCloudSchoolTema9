package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Grade;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    public Grade createGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }
}
