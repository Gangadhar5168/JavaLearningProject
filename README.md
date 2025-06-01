# Student-Teacher Grade Management System

A simple Java console-based application to manage student grades with role-based access for **Teachers** and **Students**.

## Features

-  User Registration and Login
- Teacher Module
  - Enter grades for students
  - View all student grades
- Student Module
  - View personal grades
- File-based storage (no database needed)
- Structured code using modular Java packages

## Project Structure

JavaLearningProject/
├── auth/
│ └── AuthService.java
│ └── User.java
├── student/
│ └── StudentService.java
├── teacher/
│ └── TeacherService.java
├── main/
│ └── Main.java
├── usersFile.txt
├── gradesFile.txt
├── .gitignore
└── README.md


##  Modules

###  Teacher
- Can login and:
  - Enter grades for any student
  - View all grades

###  Student
- Can login and:
  - View their own grades

##  How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/Gangadhar5168/StudentGradeManagement.git
   cd StudentGradeManagement
2. Compile and run:
    javac main/Main.java
    java main.Main

Files Used
usersFile.txt – stores user credentials and roles

gradesFile.txt – stores grade information in format: username,subject,grade

Requirements
Java 8 or higher

Text-based console

Contributions
Feel free to fork and enhance the features! Pull requests are welcome.

Contact
Developed with ❤️ by V G Prathap CH