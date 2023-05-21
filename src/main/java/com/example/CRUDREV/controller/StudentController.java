package com.example.CRUDREV.controller;


import com.example.CRUDREV.exception.ResourceNotFound;
import com.example.CRUDREV.model.Student;
import com.example.CRUDREV.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
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
    public Student createEmployee( @RequestBody Student student) {
        return studentRepo.save(student);

    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) throws ResourceNotFound{

        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound(("Student not found for this id :"+id)));
        return ResponseEntity.ok().body(student);
    }






}
