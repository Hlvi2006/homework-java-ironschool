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
    Teacher teacher1=new Teacher(1200.0,"Ulvi");
    Teacher teacher2=new Teacher(1100.0,"Nihad");
    Teacher teacher3=new Teacher(1500.0,"Ruzi");

    public TeacherService() {
        teachers.put(teacher1.getTeacherId(),teacher1);
        teachers.put(teacher2.getTeacherId(),teacher2);
        teachers.put(teacher3.getTeacherId(),teacher3);
    }

    public List<Teacher> getAllTeachers() {

        return new ArrayList<>(teachers.values());
    }
    public Teacher getTeacherById(String id) {
        Teacher newTeacher = teachers.get(id);
        if(newTeacher == null){
            throw new RuntimeException("Could not find Teacher with this id: " + id);
        }
        return newTeacher;
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

    public Teacher fullUpdate(String id, String name, Double salary){
        Teacher foundTeacher = getTeacherById(id);
        foundTeacher.setName(name);
        foundTeacher.setSalary(salary);
        return foundTeacher;
    }
    public Teacher updatePartially(String id,Teacher teacher){
        Teacher updatedTeacher = getTeacherById(id);
        if(teacher.getName()!= null) updatedTeacher.setName(teacher.getName());
        if(teacher.getSalary() != 0) updatedTeacher.setSalary(teacher.getSalary());
        return updatedTeacher;
    }

}
