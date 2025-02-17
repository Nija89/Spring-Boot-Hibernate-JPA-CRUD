package com.demo.crudDemoHibernate.DAO;

import com.demo.crudDemoHibernate.Entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findByID(int n);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    Student findByID1(int n);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
