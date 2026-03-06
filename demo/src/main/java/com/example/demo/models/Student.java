package com.example.demo.models;

import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    // private Course course;

    public Student(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.studentId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
