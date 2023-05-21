package com.example.CRUDREV.model;

import jakarta.persistence.*;


@Entity
@Table(name="studentdb")
public class Student {
    private String studentId;
    private String studentName;
    private String emailId;
    private String department;


    public Student() {

    }

    public Student(String studentId, String studentName, String emailId, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.emailId = emailId;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "name", nullable = false)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    @Column(name = "emailid", nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "department", nullable = false)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
