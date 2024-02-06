package com.demo.Students.controller;

import com.demo.Students.entity.Student;
import com.demo.Students.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("{id}")
    public  ResponseEntity<Student> getStudentId(@PathVariable("id") Long studentId){
        Student student=studentService.getStudentByID(studentId);
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student s=studentService.createStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> student=studentService.getAllStudents();
        return ResponseEntity.ok(student);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody Student updateStudent){
        Student student=studentService.updateStudent(id,updateStudent);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.delateStudent(id);
        return ResponseEntity.ok("id is successfully deleted");
    }
}
