package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> list;

    @PostConstruct
    public void loadData() {
        list = new ArrayList<>();

        list.add(new Student("poornima", "patel"));
        list.add(new Student("akshat", "bisht"));
        list.add(new Student("nishant", "sharma"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if ((studentId > list.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student Id not found: " + studentId);
        }
        return list.get(studentId);
    }
}
