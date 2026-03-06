package com.example.demo.models;

import java.util.UUID;

public class Course {
    private String courseId;
    private String name;
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


    //getters
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
