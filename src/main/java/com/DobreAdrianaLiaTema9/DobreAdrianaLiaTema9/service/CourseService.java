package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.repository.CourseRepository;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public List<Course> getAllCoursesCreditPointsGreaterThanThree(){
        return courseRepository.findAll()
                .stream()
                .filter((Course course) -> course.getCreditPoints() >= 3)
                .collect(Collectors.toList());
    }
}
