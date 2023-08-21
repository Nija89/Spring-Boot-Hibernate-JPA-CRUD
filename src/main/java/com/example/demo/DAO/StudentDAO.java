package com.example.demo.DAO;

import com.example.demo.Entity.Student;

import java.util.List;

public interface StudentDAO {

    void addStudent(Student student);

    Student findByID(Integer n);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateStudent(Student student);

    Student deleteStudentByID(Integer id);

    Integer deleteAll();
}
