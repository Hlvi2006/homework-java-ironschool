package com.example.demo.models;

import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;

    public Teacher(double salary, String name) {
        this.salary = salary;
        this.name = name;
        this.teacherId= UUID.randomUUID().toString();
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

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
