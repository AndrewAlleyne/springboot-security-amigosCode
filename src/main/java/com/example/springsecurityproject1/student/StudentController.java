package com.example.springsecurityproject1.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")

public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "James Bond"), new Student(2, "Johnny English"), new Student (3, "Tom Cruise"));

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer id) {
        return  STUDENTS.stream().filter(student -> id.equals(student.getStudentId())).findFirst().orElseThrow(() -> new IllegalStateException("Student " + id + " does not exist!"));
    }
}
