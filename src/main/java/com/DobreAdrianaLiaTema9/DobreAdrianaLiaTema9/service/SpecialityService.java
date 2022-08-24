package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception.*;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.SpecialityRepository;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Speciality;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Student;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityService {
    private final SpecialityRepository specialityRepository;
    private final StudentRepository studentRepository;

    public Speciality createSpeciality(Speciality speciality){
        return specialityRepository.save(speciality);
    }

    public List<Speciality> getAllSpecialities(){
        return specialityRepository.findAll();
    }

    public List<Student> getStudentsOfSpeciality(Integer specialityId) throws NoSpecialityException {
        Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(NoSpecialityException::new);
        return speciality.getStudents();
    }

    public void addStudent(Integer specialityId, Integer studentId) throws NoSpecialityException, NoStudentException {
        Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(NoSpecialityException::new);
        Student student = studentRepository.findById(studentId).orElseThrow(NoStudentException::new);
        speciality.addStudent(student);
        specialityRepository.save(speciality);
    }

    public Speciality getWithMaxStudents() throws SpecialityListEmptyException {
        return specialityRepository.findAll().stream()
                .max(Comparator.comparing((Speciality specility) -> specility.getStudents().size()))
                .orElseThrow(SpecialityListEmptyException::new);
    }


    public Integer calculateAverage(Integer specialityId) throws NoSpecialityException, GradeListEmptyException, StudentListEmptyException, NoGradeException {
        Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(NoSpecialityException::new);
        List<Student> students = speciality.getStudents();
        if (students.isEmpty())
            throw new StudentListEmptyException();
        else {
            Integer sum = 0;
            for(Student student : students)
                if (student.getGrades().isEmpty())
                    throw new NoGradeException();
                else
                    sum += student.calculateAnnualAverageGrade();
            return sum/students.size();
            }
    }

    public Student getWithMaxAverage(Integer specialityId) throws NoSpecialityException, StudentListEmptyException {
        Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(NoSpecialityException::new);
        return speciality.getStudents().stream()
                .max(Comparator.comparing(student -> {
                    try {
                        return student.calculateAnnualAverageGrade();
                    } catch (GradeListEmptyException e) {
                        throw new RuntimeException(e);
                    }
                })).orElseThrow(StudentListEmptyException::new);
    }
}
