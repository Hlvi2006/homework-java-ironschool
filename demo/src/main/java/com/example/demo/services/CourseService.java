package com.example.demo.services;


import com.example.demo.controllers.CourseController;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    Map<String, Course> courses = new HashMap<>();

    public CourseService(){
        Course course1 = new Course("English", 50.0);
        Course course2 = new Course("Spanish", 60.0);
        Course course3 = new Course("Portuguese", 70.0);
        courses.put(course1.getCourseId(), course1);
        courses.put(course2.getCourseId(), course2);
        courses.put(course3.getCourseId(), course3);
    }

    public List<Course> findAll(){
        return courses.values().stream().toList();
    }

    public Course create(String name, Double price){
        Course createdCourse = new Course();
        createdCourse.setName(name);
        createdCourse.setPrice(price);
        courses.put(createdCourse.getCourseId(), createdCourse);
        return createdCourse;
    }

    public Course findById(String id){
        Course foundCourse = courses.get(id);
        if(foundCourse == null){
            throw new ResourceNotFoundException("Could not find course with id: " + id);
        }
        return foundCourse;
    }

    public List<Course> findByName(String name){
        return courses.values().stream().filter(c -> c.getName().contains(name)).toList();
    }

    public List<Course> findByPriceRange(Double minPrice, Double maxPrice){
        return courses.values().stream().filter(c -> Double.compare(c.getPrice(), minPrice) >= 0 && Double.compare(c.getPrice(), maxPrice) <= 0).toList();
    }

    public Course fullUpdate(String id, String name, Double price, Double moneyEarned, Teacher teacher){
        Course foundCourse = findById(id);
        foundCourse.setName(name);
        foundCourse.setPrice(price);
        foundCourse.setMoney_earned(moneyEarned);
        foundCourse.setTeacher(teacher);
        return foundCourse;
    }

    public Course partialUpdate(String id, String name, Double price, Double moneyEarned, Teacher teacher){
        Course foundCourse = findById(id);

        if(name != null){
            foundCourse.setName(name);
        }
        if(price != null){
            foundCourse.setPrice(price);
        }
        if(moneyEarned != null){
            foundCourse.setMoney_earned(moneyEarned);
        }
        if(teacher != null){
            foundCourse.setTeacher(teacher);
        }
        return foundCourse;
    }

    public void delete(String id){
        findById(id);
        courses.remove(id);
    }
}
