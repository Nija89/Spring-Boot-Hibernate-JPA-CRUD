package com.example.demo;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
				addStudent(studentDAO);
				//findByID(studentDAO);
				//findAll(studentDAO);
				//findByLastName(studentDAO);
				//updateStudent(studentDAO);
				//deleteStudentByID(studentDAO);
				//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int x = studentDAO.deleteAll();
		System.out.println("Total Number os Student deleted: "+ x);

	}

	private void deleteStudentByID(StudentDAO studentDAO) {
			Integer id = 4;
			Student deletedStudent = studentDAO.deleteStudentByID(id);
		System.out.println("Deleting student at: " + id + " with information: " + deletedStudent);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		Student myStudent = studentDAO.findByID(1);
		System.out.println("Updating information: " +
				myStudent);
		myStudent.setFirstName("Suace");

		System.out.println("Updated to: " +	myStudent);
	}

	private void findByLastName(StudentDAO studentDAO) {
		String lastName = "F3";
		List<Student> myList = studentDAO.findByLastName(lastName);
		for(Student myStudent: myList){
			System.out.println(myStudent);
		}
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> myList = studentDAO.findAll();
		for(Student myStudent: myList){
			System.out.println(myStudent);
		}
	}

	private void findByID(StudentDAO studentDAO) {
			Integer x = 2;
			Student myStudent = studentDAO.findByID(x);
		System.out.println("Student with ID: " + x +
				" information is : " + myStudent.toString());
	}


	public static void addStudent(StudentDAO studentDAO){
		System.out.println("Creating .....");
		studentDAO.addStudent(new Student("Apple", "F1" , "apple@fruit.com"));
		studentDAO.addStudent(new Student("Banana", "F2" , "banana@fruit.com"));
		studentDAO.addStudent(new Student("Cherry", "F3" , "cherry@fruit.com"));
		studentDAO.addStudent(new Student("Dragon", "F4" , "dragon@fruit.com"));
		System.out.println("Saved ...");
	}

}
