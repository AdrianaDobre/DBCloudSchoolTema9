package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAll();
    Optional<Student> findById(Integer studentId);
}
