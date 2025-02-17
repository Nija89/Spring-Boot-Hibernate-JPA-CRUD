package com.demo.crudDemoHibernate;

import com.demo.crudDemoHibernate.DAO.StudentDAO;
import com.demo.crudDemoHibernate.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class  CrudDemoHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudentDAO(studentDAO);
//			findByIdStudent(studentDAO);
//			findAllStudent(studentDAO);
//			findByLastName(studentDAO);
//			findByID1(studentDAO);
//			update(studentDAO);
//			delete(studentDAO);
//			deleteAll(studentDAO);
		};
	}
	private void deleteAll(StudentDAO studentDAO){
		System.out.println(studentDAO.deleteAll());
	}

	private void delete(StudentDAO studentDAO){
		int id = 1;
		studentDAO.delete(id);
	}

	private void update(StudentDAO studentDAO){
		Student theStudent = studentDAO.findByID1(1);

		theStudent.setFirstName("Apple");

		studentDAO.update(theStudent);

		System.out.println(theStudent);
	}

	private Student findByID1(StudentDAO studentDAO){
		return studentDAO.findByID1(3);
	}

	private void findByLastName(StudentDAO studentDAO){
		List<Student> theStudent = studentDAO.findByLastName("X");
		for(Student x : theStudent) {
			System.out.println(x);
		}

	}
	private void findAllStudent(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findAll();
		for(Student x : theStudent) {
			System.out.println(x);
		}
	}

	private void findByIdStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findByID(1));
	}

	public void createStudentDAO(StudentDAO studentDAO){

		System.out.println("Creating Student Object");
		Student tempStudnet = new Student("A", "X", "ax@gmail.com");
		Student tempStudnet1 = new Student("B", "Y", "by@gmail.com");
		Student tempStudnet2 = new Student("C", "Z", "cz@gmail.com");

		System.out.println("Saving student");
		studentDAO.save(tempStudnet);
		studentDAO.save(tempStudnet1);
		studentDAO.save(tempStudnet2);

		System.out.println("Saved student.");

	}

}
