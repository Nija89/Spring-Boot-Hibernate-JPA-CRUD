package com.demo.crudDemoHibernate.DAO;

import com.demo.crudDemoHibernate.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findByID(int n){
        return entityManager.find(Student.class, n);
    }
    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName desc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =: x ", Student.class);
        theQuery.setParameter("x", lastName);
        return theQuery.getResultList();
    }

    @Override
    public Student findByID1(int n) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE id=:x", Student.class);
        theQuery.setParameter("x", n);
        return theQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id){
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int n = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return n;
    }
}
