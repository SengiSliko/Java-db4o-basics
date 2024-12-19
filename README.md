# Java db4o Assignment

## Overview

This project demonstrates the use of **db4o** (database for objects) to handle database operations in Java.  
It involves creating persistent objects, performing CRUD (Create, Read, Update, Delete) operations, and executing queries on a **db4o** database.

The project showcases an understanding of object-oriented programming and the practical implementation of a lightweight object database in Java.

---

## Objectives

The primary goals of this project are to:

- Implement Java classes and make them persistent by storing them in a **db4o** database.
- Demonstrate the ability to:
  - Insert objects into the database.
  - Modify objects in the database.
  - Retrieve objects using different query mechanisms (QBE, SODA).
  - Delete objects from the database.

---

## Features

The project implements the following:

1. **Persistent Objects**:
   - `DegreeProgram`: Represents a degree program with attributes like `degreeName`, `department`, and `faculty`.
   - `Student`: A base class for students with attributes like `degreeProgram`, `studentNumber`, `name`, and `surname`.
   - `Undergraduate`: A subclass of `Student` with additional attributes `yearOfStudy` and `averageMark`.
   - `Postgraduate`: A subclass of `Student` with additional attributes `supervisorInitials`, `supervisorSurname`, and `researchTopic`.

2. **CRUD Operations**:
   - Add new degree programs, undergraduate, and postgraduate students.
   - List all students (undergraduate and postgraduate).
   - Search for students using QBE (Query by Example) and SODA (Simple Object Database Access).
   - Update student details (depending on their type).

3. **Database File**:
   - Persistent storage is handled using `database.db4o`.

---

## Project Structure

### Folders

- **Application**: Contains the `.jar` file and other executable files.
- **Source**: Contains all `.java` source code files.

### Java Classes

- `Database.java`: Handles database operations such as adding, retrieving, updating, and deleting objects.
- `Tester.java`: Contains the main menu-driven interface for interacting with the application.
- `DegreeProgram.java`: Defines the degree program structure.
- `Student.java`: Base class for students.
- `Undergraduate.java`: Subclass for undergraduate students.
- `Postgraduate.java`: Subclass for postgraduate students.

### Database File

- `database.db4o`: The db4o database file used for storing persistent objects.

---

## How to Run

1. Compile all `.java` files in the **Source** folder.
2. Execute the `Tester` class to launch the menu-driven application.
3. Interact with the application using the following menu options:
   1. Add degree program.
   2. Add undergraduate student.
   3. Add postgraduate student.
   4. List all students.
   5. Find postgraduate student (QBE).
   6. Find undergraduate student (QBE or SODA).
   7. Update student.

---

## Technologies Used

- **Java**: Programming language used for implementation.
- **db4o**: Object-oriented database for Java.
- **Eclipse/JetBrains Rider/IntelliJ IDEA**: (optional) IDE for development and testing.

---
