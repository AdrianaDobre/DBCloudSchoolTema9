package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findAll();
    Optional<Professor> findById(Integer professorId);
}
