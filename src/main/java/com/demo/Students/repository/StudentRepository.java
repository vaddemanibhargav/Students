package com.demo.Students.repository;

import com.demo.Students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<Student,Long> {
}
