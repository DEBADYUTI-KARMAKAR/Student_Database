package com.example.CRUDREV.controller;


import com.example.CRUDREV.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping()
    public String home(){
        return "Welcome to Unmeshanam";
    }

}
