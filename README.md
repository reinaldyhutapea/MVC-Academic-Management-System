# Academic Management System

## Overview

This README provides a detailed explanation of an Academic Management System implemented in Java. The system follows the Model-View-Controller (MVC) architecture and encompasses various classes and functionalities to manage academic entities like courses, students, lecturers, and enrollments.

## Table of Contents

1. [Introduction](#introduction)
2. [Key Concepts](#key-concepts)
    - [Course](#course)
    - [Student](#student)
    - [Enrollment](#enrollment)
    - [Lecturer](#lecturer)
    - [Person and PersonDetail](#person-and-persondetail)
    - [CourseOpening](#courseopening)
    - [Controller and Executor](#controller-and-executor)
3. [Usage and Commands](#usage-and-commands)
4. [Test Case Example](#test-case-example)

---

## 1. Introduction

The Academic Management System implemented in Java allows for the management of academic-related entities through a command-line interface. It leverages the MVC design pattern to separate concerns and achieve modularity.

## 2. Key Concepts

### Course

The `Course` class represents a specific course offered within the academic system. It contains attributes such as course code, name, credits, and grade.

### Student

The `Student` class extends `Person` and represents a student within the academic environment. It includes additional attributes like academic year and major.

### Enrollment

The `Enrollment` class manages the enrollment of students in courses, storing details such as student ID, course ID, academic year, semester, and grades.

### Lecturer

The `Lecturer` class extends `Person` and represents a faculty member who teaches courses. It includes attributes like initials, email, and study program.

### Person and PersonDetail

The `Person` class is the base class for `Student` and `Lecturer`, defining common attributes like ID and name. The `PersonDetail` interface provides methods to retrieve ID and name.

### CourseOpening

The `CourseOpening` class represents an instance of a course being offered during a specific academic year and semester, associated with one or more lecturers.

### Controller and Executor

The `Controller` class handles user input commands and delegates tasks to the `Executor`, which interacts with the model classes (`Course`, `Student`, `Enrollment`, etc.) to execute the requested operations.

## 3. Usage and Commands

The main entry point of the system is the `Driver1` class, which serves as the user interface. Users interact with the system by entering commands in a predefined format, triggering actions like adding courses, students, lecturers, enrollments, and more.

Supported commands include:
- `course-add`
- `student-add`
- `enrollment-add`
- `lecturer-add`
- `enrollment-grade`
- `student-details`
- `enrollment-remedial`
- `course-open`
- `course-history`

## 4. Test Case Example

A test case example is provided to demonstrate the usage of the system with specific commands and expected outputs. This showcases how to perform actions like adding courses, opening courses, enrolling students, assigning grades, and retrieving course history.

#input:

lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
lecturer-add#0124108201#Rosni Lumbantoruan#RSL#rosni@del.ac.id#Information Systems
course-add#12S1101#Dasar Sistem Informasi#3#D
student-add#12S20001#Marcelino Manalu#2020#Information Systems
student-add#12S20002#Yoga Sihombing#2020#Information Systems
student-add#12S20003#Marcel Simanjuntak#2020#Information Systems
course-open#12S1101#2020/2021#odd#IUS
enrollment-add#12S1101#12S20001#2020/2021#odd
enrollment-add#12S1101#12S20002#2020/2021#odd
enrollment-add#12S1101#12S20003#2020/2021#odd
enrollment-grade#12S1101#12S20001#2020/2021#odd#B
enrollment-grade#12S1101#12S20002#2020/2021#odd#B
enrollment-grade#12S1101#12S20003#2020/2021#odd#B
course-open#12S1101#2020/2021#even#IUS
course-open#12S1101#2021/2022#odd#IUS
enrollment-add#12S1101#12S20002#2021/2022#odd
enrollment-add#12S1101#12S20003#2021/2022#odd
enrollment-grade#12S1101#12S20002#2021/2022#odd#C
enrollment-grade#12S1101#12S20003#2021/2022#odd#AB
enrollment-remedial#12S1101#12S20002#2021/2022#odd#B
enrollment-add#12S1101#12S20001#2020/2021#even
enrollment-add#12S1101#12S20002#2020/2021#even
enrollment-add#12S1101#12S20003#2020/2021#even
enrollment-grade#12S1101#12S20001#2020/2021#even#BC
enrollment-grade#12S1101#12S20002#2020/2021#even#A
enrollment-grade#12S1101#12S20003#2020/2021#even#A
enrollment-remedial#12S1101#12S20001#2020/2021#even#AB
course-history#12S1101
---

#output:
12S1101|Dasar Sistem Informasi|3|D|2020/2021|odd|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|B
12S1101|12S20003|2020/2021|odd|B
12S1101|Dasar Sistem Informasi|3|D|2021/2022|odd|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20002|2021/2022|odd|B(C)
12S1101|12S20003|2021/2022|odd|AB
12S1101|Dasar Sistem Informasi|3|D|2020/2021|even|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20001|2020/2021|even|AB(BC)
12S1101|12S20002|2020/2021|even|A
12S1101|12S20003|2020/2021|even|A
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics
0124108201|Rosni Lumbantoruan|RSL|rosni@del.ac.id|Information Systems
12S1101|Dasar Sistem Informasi|3|D
12S20001|Marcelino Manalu|2020|Information Systems
12S20002|Yoga Sihombing|2020|Information Systems
12S20003|Marcel Simanjuntak|2020|Information Systems
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|B
12S1101|12S20003|2020/2021|odd|B
12S1101|12S20002|2021/2022|odd|B(C)
12S1101|12S20003|2021/2022|odd|AB
12S1101|12S20001|2020/2021|even|AB(BC)
12S1101|12S20002|2020/2021|even|A
12S1101|12S20003|2020/2021|even|A


This README serves as a comprehensive guide to understanding the Academic Management System's implementation in Java. For further details on individual classes, methods, and interactions, refer to the source code documentation and comments.

If you have any questions or need assistance, feel free to reach out!
