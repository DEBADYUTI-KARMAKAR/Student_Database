package com.example.CRUDREV.controller;


import com.example.CRUDREV.model.Student;
import com.example.CRUDREV.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @RequestMapping()
    public String home(){
        return "Welcome to Unmeshanam";
    }

    @PostMapping
    public Student createEmployee( @RequestBody Student employee) {
        return studentRepo.save(employee);

    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }




}
