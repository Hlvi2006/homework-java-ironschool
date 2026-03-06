package com.example.demo.services;

import com.example.demo.models.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TeacherService {
    HashMap<String, Teacher> teachers = new HashMap<>();
    Teacher teacher1=new Teacher(1200,"Ulvi");
    Teacher teacher2=new Teacher(1100,"Nihad");
    Teacher teacher3=new Teacher(1500,"Ruzi");

    public TeacherService() {
        teachers.put(teacher1.getTeacherId(),teacher1);
        teachers.put(teacher2.getTeacherId(),teacher2);
        teachers.put(teacher3.getTeacherId(),teacher3);
    }

    public List<Teacher> getAllTeachers() {

        return new ArrayList<>(teachers.values());
    }
    public Teacher getTeacherById(String id) {
        return teachers.get(id);
    }
    public Teacher createTeacher(Teacher teacher) {

        Teacher createdTeacher=new Teacher();
        createdTeacher.setName(teacher.getName());
        createdTeacher.setSalary(teacher.getSalary());
        teachers.put(createdTeacher.getTeacherId(), createdTeacher);
        return createdTeacher;
    }
    public List<Teacher> getTeachersByName(String name) {
        ArrayList<Teacher> selectedTeachersByName=new ArrayList<>();
        for(Teacher teacher:teachers.values()){
            if(teacher.getName().equals(name)){
                selectedTeachersByName.add(teacher);
            }
        }
        return selectedTeachersByName;
    }
    public List<Teacher> getTeachersBySalaryRange(double min,double max){
        ArrayList<Teacher> selectedTeachersByName=new ArrayList<>();
        for(Teacher teacher:teachers.values()){
            if(teacher.getSalary()>=min && teacher.getSalary()<=max){
                selectedTeachersByName.add(teacher);
            }
        }
        return  selectedTeachersByName;
    }

}
