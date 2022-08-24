package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findAll();
    Optional<Course> findById(Integer courseId);
}
