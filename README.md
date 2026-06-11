# 🎓 Student Registration System (Java + MySQL)

A simple student registration system built with **Java** and **MySQL (XAMPP)**. The system allows users to register students, view student records, and manage basic CRUD operations.

---

## 🚀 Features
- Register new students
- View student details
- Update student information
- Delete student records
- Database integration with MySQL (via JDBC)

---

## 🛠️ Tech Stack
- **Java (JDK 17+)**
- **MySQL (XAMPP)**
- **JDBC**
- **NetBeans**

---

## 📥 Database Setup (XAMPP + MySQL)

To run this project, you need to set up the database using **phpMyAdmin**:

1. Open **XAMPP Control Panel** and start **Apache** and **MySQL**.
2. Go to [http://localhost/phpmyadmin](http://localhost/phpmyadmin).
3. Click **Databases** and create a new database (e.g., `student`).
4. Select the new database, then go to the **Import** tab.
5. Click **Choose File** and select the provided `student.sql` file from this repository.
6. Click **Go** to import the tables and data.
7. Update your Java project’s database connection settings (JDBC or `application.properties`) to match:
   ```properties
    String URL = "Jdbc:mysql://localhost:3306/student";
    String USER = "root";
    String PASS = "";
   
---

## 🛠️ Installation

### 1. Clone the repository
```bash
git clone https://github.com/funwi6191/Student-Registration-System.git
cd Student-Registration-System


