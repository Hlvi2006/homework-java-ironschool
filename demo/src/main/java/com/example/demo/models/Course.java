package com.example.demo.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class Course {
    private final String courseId;

    @Size(min = 2, max = 50, message = "Course name must be between 2-50 characters!")
    private String name;

    @Min(value = 0, message = "Course price cannot be negative!")
    private Double price;
    private Double money_earned;
    private Teacher teacher;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
        this.courseId = UUID.randomUUID().toString();
    }

    public Course() {
        this.courseId = UUID.randomUUID().toString();
    }


    //gettersmd
    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getMoney_earned() {
        return money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setMoney_earned(Double money_earned) {
        this.money_earned = money_earned;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
