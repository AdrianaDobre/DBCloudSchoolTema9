package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {
    List<Speciality> findAll();
    Optional<Speciality> findById(Integer specialityId);
}
