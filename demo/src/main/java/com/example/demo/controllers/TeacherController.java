package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.services.TeacherService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public List<Teacher> getStudents(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable String id){
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }
   @GetMapping("/name")
    public List<Teacher> getTeachersByName(@RequestParam String name){
        return teacherService.getTeachersByName(name);
   }
   @GetMapping("/salary")
    public List<Teacher> getteacherBySalary(@RequestParam double min,@RequestParam double max){
        return teacherService.getTeachersBySalaryRange(min,max);
   }

   @PutMapping("/{id}")
    public Teacher replaceTeacher(@PathVariable String id, @Valid @RequestBody Teacher teacher){
        return teacherService.fullUpdate(id, teacher.getName(), teacher.getSalary());
   }
}
