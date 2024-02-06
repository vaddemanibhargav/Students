package com.demo.Students.service.impl.impl;

import com.demo.Students.entity.Student;
import com.demo.Students.exception.ResourseNotFoundExceptoin;
import com.demo.Students.repository.StudentRepository;
import com.demo.Students.service.impl.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        System.out.println(student.getDepartment()+"test " +student.getFullName());
       return studentRepository.save(student);

    }

    @Override
    public Student getStudentByID(Long id) {
        Student student=studentRepository.findById(id).orElseThrow(
                ()-> new ResourseNotFoundExceptoin("Student id is not found"+id)
        );
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> student=studentRepository.findAll();
        return student;
    }

    @Override
    public Student updateStudent(Long studentId, Student updateId) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new ResourseNotFoundExceptoin("Id is not found"+studentId)
        );
        student.setId(updateId.getId());
        student.setFullName(updateId.getFullName());
        student.setDepartment(updateId.getDepartment());
        Student student1=studentRepository.save(student);
        return student1;
    }

    @Override
    public void delateStudent(Long id) {
        Student student=studentRepository.findById(id).orElseThrow(
                ()->new ResourseNotFoundExceptoin("id not found"+id)
        );
        studentRepository.deleteById(id);
    }
}
