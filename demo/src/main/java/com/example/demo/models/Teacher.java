package com.example.demo.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class Teacher {
    private String teacherId;

    @NotNull
    @Size(min = 2, max = 50,message = "Name must be in valid size")
    private String name;

    @NotNull
    @Positive
    private Double salary;

    public  Teacher(){
        this.teacherId= UUID.randomUUID().toString();
    }
    public Teacher(double salary, String name) {
        this.salary = salary;
        this.name = name;
        this.teacherId= UUID.randomUUID().toString();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
