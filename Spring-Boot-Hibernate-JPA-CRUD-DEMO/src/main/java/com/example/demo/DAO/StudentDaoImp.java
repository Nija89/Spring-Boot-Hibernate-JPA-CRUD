package com.example.demo.DAO;

import com.example.demo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImp implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByID(Integer n) {
        Student myStudent = entityManager.find(Student.class,n);
        return myStudent;
    }


    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        return theQuery.getResultList();
    }


    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public Student deleteStudentByID(Integer id) {
        Student myStudent = entityManager.find(Student.class,id);
        entityManager.remove(myStudent);
        return myStudent;
    }

    @Override
    @Transactional
    public Integer deleteAll() {
        int n = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return n;
    }
}
