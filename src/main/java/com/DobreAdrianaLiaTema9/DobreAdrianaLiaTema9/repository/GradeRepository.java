package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
    Optional<Grade> findById(Integer gradeId);
}
