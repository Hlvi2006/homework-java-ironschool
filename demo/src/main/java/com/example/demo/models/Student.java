package com.example.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class Student {
    private String studentId;
    @Size(min = 2, max = 50,message = "Name must be in valid size")
    private String name;
    private String address;
    @Email(message = "Must e in email format")
    private String email;
    private Course course;

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
