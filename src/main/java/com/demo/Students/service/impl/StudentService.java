package com.demo.Students.service.impl;

import com.demo.Students.entity.Student;

import java.util.List;

public interface StudentService  {
    Student createStudent(Student student);
    Student getStudentByID(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long studentId,Student updateId);
    void delateStudent(Long id);

}
