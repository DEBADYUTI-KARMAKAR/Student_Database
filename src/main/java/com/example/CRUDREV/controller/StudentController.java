package com.example.CRUDREV.controller;


import com.example.CRUDREV.exception.ResourceNotFound;
import com.example.CRUDREV.model.Student;
import com.example.CRUDREV.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") String studentId, @RequestBody Student studentDetails) throws ResourceNotFound {
        Student student = studentRepo.findById(String.valueOf(studentId)).orElseThrow(() -> new ResourceNotFound("Student not found"));

        student.setStudentName(studentDetails.getStudentName());
        student.setDepartment(studentDetails.getDepartment());
        student.setEmailId(studentDetails.getEmailId());

        final Student updateStudent = studentRepo.save(student);
        return ResponseEntity.ok(updateStudent);


    }



    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteStudent(@PathVariable(value = "id") String studentId) throws ResourceNotFound{
        Student student = studentRepo.findById(studentId).orElseThrow(()->new ResolutionException("Student is not found with this is:"+studentId));

        studentRepo.delete(student);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;


    }





}
