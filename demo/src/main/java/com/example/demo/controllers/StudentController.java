package com.example.demo.controllers;


import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.findById(id);
    }

    @GetMapping("/search/name")
    public List<Student> getStudentByName(@RequestParam String name){
        return studentService.findByName(name);
    }
}
