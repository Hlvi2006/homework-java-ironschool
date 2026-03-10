package com.example.demo.controllers;


import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Student getStudentById( @PathVariable String id){
        return studentService.findById(id);
    }

    @GetMapping("/search/name")
    public List<Student> getStudentByName( @RequestParam String name){
        return studentService.findByName(name);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id,@RequestBody Student student){
        Student updatedStudent=studentService.updateStudent(id,student);
        return ResponseEntity.ok(updatedStudent);
    }
    @PatchMapping("/{id}")
    public Student updatePartialStudent(@PathVariable String id,@RequestBody Student student){
        return studentService.updateStudentPartially(id,student);
    }
}
