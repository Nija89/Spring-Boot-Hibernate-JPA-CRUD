# Spring-Boot-Hibernate-JPA-CRUD

This is a simple CRUD (Create, Read, Update, Delete) application using Hibernate with Spring Boot. It demonstrates basic operations on a `Student` entity, which includes the following features:

- **Create**: Add new student records to the database.
- **Read**: Retrieve student records based on ID and last name.
- **Update**: Modify student details like the first name.
- **Delete**: Remove a student record or delete all student records from the database.

## Features

- Save student information including `firstName`, `lastName`, and `email`.
- Find students by `id` and `lastName`.
- Update a student's details.
- Delete a specific student or delete all students.

## Installation

1. Clone the repository:

   ```bash
   https://github.com/Nija89/Spring-Boot-Hibernate-JPA-CRUD
2. Navigate to the project directory:

    ```bash
    cd crud-demo-hibernate
3. Install dependencies:

    ```bash
    mvn install
4. Run the application:

    ```bash
    mvn spring-boot:run

## Console Output
All CRUD operations are visible in the console, where you will see output for:

- Saving new students to the database.
- Retrieving and printing student details.
- Updating student information.
- Deleting student records or deleting all students.