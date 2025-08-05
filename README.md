# Student Record Management System

## 🎯 Overview

This project implements a Student Record Management System that allows users to perform various operations on student data through a command-line interface. The system demonstrates core Java concepts including object-oriented programming, collections framework, and user input handling.

## ✨ Features

### Core CRUD Operations
- **Add Student**: Create new student records with unique ID validation
- **View All Students**: Display all students in a formatted table
- **Update Student**: Modify existing student information
- **Delete Student**: Remove student records with confirmation
- **Search Student**: Find students by ID or name (partial match supported)
- **Sort Students**: Sort by ID, name, or marks in different orders

### Additional Features
- **Input Validation**: Comprehensive error handling and data validation
- **User-Friendly Interface**: Clean CLI with formatted menus and output
- **Duplicate Prevention**: Prevents adding students with existing IDs
- **Data Persistence**: Maintains data during program execution
- **Professional Formatting**: Organized display with dividers and alignment

## 🛠 Technologies Used

- **Java**: Core programming language
- **ArrayList**: Dynamic data storage
- **Collections Framework**: For sorting functionality
- **Scanner**: User input handling
- **Object-Oriented Programming**: Classes, encapsulation, constructors

## 💻 Usage

### Main Menu Options

```
=============================================================
                    MAIN MENU
=============================================================
1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Search Student
6. Sort Students
7. Exit
=============================================================
```

### Sample Workflow

1. **Adding a Student**
   - Choose option 1
   - Enter unique Student ID
   - Enter Student Name
   - Enter Marks (0-100)

2. **Viewing Students**
   - Choose option 2
   - View formatted list of all students

3. **Updating Student**
   - Choose option 3
   - Enter Student ID to update
   - Modify name and/or marks (press Enter to keep current values)

4. **Searching Students**
   - Choose option 5
   - Search by ID (exact match) or Name (partial match)

### Key Classes and Methods

#### Student Class
- **Fields**: `private int id`, `private String name`, `private double marks`
- **Constructors**: Default and parameterized constructor overloading
- **Methods**: Getters, setters, and toString() for formatted output

#### Main Class Methods
- `addStudent()`: Add new student with validation
- `viewAllStudents()`: Display all students
- `updateStudent()`: Modify existing student data
- `deleteStudent()`: Remove student with confirmation
- `searchStudent()`: Find students by ID or name
- `sortStudents()`: Sort by different criteria
- `findStudentById()`: Helper method for ID-based operations

## 🎓 Key Concepts Demonstrated

### Object-Oriented Programming
- **Encapsulation**: Private fields with public getters/setters
- **Constructor Overloading**: Multiple constructor implementations
- **Access Modifiers**: Proper use of private, public keywords

### Java Collections
- **ArrayList**: Dynamic array implementation for student storage
- **Collections.sort()**: Sorting with custom comparators
- **Comparator Interface**: Custom sorting logic

### Error Handling
- **Try-Catch Blocks**: NumberFormatException handling
- **Input Validation**: Data type and range validation
- **Defensive Programming**: Null checks and boundary conditions

### Best Practices
- **Code Organization**: Logical method separation
- **User Experience**: Clear prompts and formatted output
- **Data Integrity**: Duplicate prevention and validation

## 📸 Screenshots

### Main Menu
```
=============================================================
                    MAIN MENU
=============================================================
1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Search Student
6. Sort Students
7. Exit
=============================================================
```

### Student List Display
```
=============================================================
                ALL STUDENTS
=============================================================
Total Students: 3
------------------------------------------------------------
ID: 101   | Name: John Doe            | Marks: 85.50
ID: 102   | Name: Jane Smith          | Marks: 92.00
ID: 103   | Name: Mike Johnson        | Marks: 78.25
```
