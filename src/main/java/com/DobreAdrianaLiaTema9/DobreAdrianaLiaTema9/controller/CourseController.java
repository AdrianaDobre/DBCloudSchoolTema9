package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.controller;

import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.model.Course;
import com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/getGreaterThan3")
    public List<Course> getAllCoursesCreditPointsGreaterThanThree(){
        return courseService.getAllCoursesCreditPointsGreaterThanThree();
    }
}
