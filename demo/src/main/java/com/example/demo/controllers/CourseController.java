package com.example.demo.controllers;


import com.example.demo.models.Course;
import com.example.demo.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id){
        return courseService.findById(id);
    }

    @GetMapping("/search/name")
    public List<Course> getCourseByName(@RequestParam String name){
        return courseService.findByName(name);
    }

    @GetMapping("/search/price")
    public List<Course> getCourseByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice){
        return courseService.findByPriceRange(minPrice, maxPrice);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody @Valid Course course){
        Course createdCourse = courseService.create(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @PutMapping("/{id}")
    public Course replaceCourse(@PathVariable String id, @Valid @RequestBody Course course){
        return courseService.fullUpdate(id, course);
    }


    @PatchMapping("/{id}")
    public Course patchCourse(@PathVariable String id, @RequestBody Course course){
        return courseService.partialUpdate(id, course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id){
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
