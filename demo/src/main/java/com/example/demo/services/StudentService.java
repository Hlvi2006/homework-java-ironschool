package com.example.demo.services;

import com.example.demo.models.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequestMapping("/student")
public class StudentService {
    HashMap<String, Student> students=new HashMap<>();
    Student student1=new Student("Arif","Baku 478","ahaciyv5@gmail.com");
    Student student2=new Student("Lale","Gence 34","laciyv5@gmail.com");
    Student student3=new Student("Nezrin","Riyad 98","Wallkiyv5@gmail.com");
    public StudentService() {
        students.put(student1.getStudentId(),student1);
        students.put(student2.getStudentId(),student2);
        students.put(student3.getStudentId(),student3);
    }

    public List<Student> findAll(){
        return new ArrayList<>(students.values()) ;
    }
    public Student findById(String id){
        return students.get(id);
    }
    public List<Student> findByName(String name){
        ArrayList<Student> selectedStudentsByName=new ArrayList<>();
        for(Student s:students.values()){
            if(s.getName().equals(name)){
                selectedStudentsByName.add(s);
            }
        }
        return selectedStudentsByName;
    }
    
}
