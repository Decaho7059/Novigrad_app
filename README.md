# 🏙️ Novigrad – Municipal Service Management Application
> Academic project developed by **Decaho Gbegbe** as part of the **SEG2505 – Introduction to Software Development** course at the **University of Ottawa (Fall 2024)**.

---

## 🎯 Project Overview

**Novigrad** is a simulated municipal service management system built entirely in **Java**, where different user roles — *employees*, *managers*, and *clients* — interact with city-style services such as driver’s license renewals, form submissions, and document verification.

The goal of this project was to apply the **core principles of software engineering** covered in **SEG2505**, including:

- Object-Oriented Programming (OOP)
- Model–View–Controller (MVC) architecture
- UML modeling and documentation
- Input validation and exception handling
- Unit testing and version control
- Collaborative software development practices

## 🎥 Demo Preview

![Novigrad Demo](images/novigrad_demo.gif)

---

## ⚙️ Technologies and Tools

| 🧩 Technology / Tool | 💡 Purpose |
|----------------------|------------|
| ☕ **Java (JDK 17+)** | Main programming language |
| 🎨 **JavaFX** | Graphical user interface (GUI) |
| 🧠 **MVC Architecture** | Separation of model, view, and controller layers |
| 🧪 **JUnit** | Unit testing and quality assurance |
| 🗂️ **Git & GitHub** | Version control and collaboration |
| 🧱 **UML Diagrams** | System design and modeling |
| 📄 **JavaDoc** | Code documentation and maintainability |

---

## 🚀 Key Features

- 👤 **User Management** – Register, log in, and manage roles (Client, Employee, Manager)  
- 🏢 **Service Management** – Create, modify, and delete municipal services  
- 📁 **Document Handling** – Upload, review, and validate client documents  
- 💾 **Persistent Storage** – File-based system for data persistence  
- 🕹️ **Interactive GUI** – Intuitive JavaFX-based user interface  
- ⚠️ **Input Validation** – Error handling and user feedback mechanisms  
- 📊 **Reporting (optional)** – View and manage service statistics  

---

## 🧠 Learning Outcomes

This project reinforced hands-on understanding of:

- **Encapsulation, Inheritance, and Polymorphism**  
- **Interfaces and Abstract Classes**  
- **Exception Handling and Validation**  
- **Collections Framework (ArrayList, HashMap, etc.)**  
- **File I/O Operations** for saving and loading data  
- **Test-Driven Development (TDD)** using JUnit  
- **Git Collaboration Workflow** (branches, commits, merges, pull requests)

---

## 👥 Roles and Responsibilities

- **Decaho Gbegbe:**  
  Developer – Design, implementation, testing, and documentation.  

- **Course Instructors & TAs:**  
  Provided functional requirements, feedback, and evaluation.  

- **Team Collaboration:**  
  Used Git and GitHub for version control and iterative code review.

---


## 🧩 Project Structure

```bash
Novigrad/
│
├── src/
│   ├── Main.java                      # Entry point
│   ├── controller/
│   │   ├── LoginController.java
│   │   ├── ServiceController.java
│   │   └── UserController.java
│   │
│   ├── model/
│   │   ├── User.java
│   │   ├── Client.java
│   │   ├── Employee.java
│   │   ├── Manager.java
│   │   ├── Service.java
│   │   └── Document.java
│   │
│   └── view/
│       ├── LoginView.java
│       ├── MainView.java
│       └── ServiceView.java
│
├── resources/
│   ├── data/                          # Files storing users and services
│   └── ui/                            # FXML files or visual assets
│
├── test/
│   ├── UserTest.java
│   ├── ServiceTest.java
│   └── FileManagerTest.java
│
└── README.md
```
---
## ⚙️ How to Run the Project
🖥️ Requirements
```bash
Java JDK 17+

JavaFX SDK (if not bundled with your IDE)

IDE such as VS Code or IntelliJ IDEA
```

## ▶️ Run in VS Code or Terminal
``` bash
1️⃣ Compile all .java files:

javac -cp src --module-path "PATH_TO_JAVAFX/lib" --add-modules javafx.controls,javafx.fxml src/**/*.java
```

##2️⃣ Run the main program:
```bash
java -cp src --module-path "PATH_TO_JAVAFX/lib" --add-modules javafx.controls,javafx.fxml Main
```

## 💡 In IntelliJ IDEA:
```bash
Go to Run → Edit Configurations → Add JavaFX Application

Set main class: Main

Apply and click Run ▶️
```
---


## 📚 Academic Context

Course: SEG2505 – Introduction to Software Development
Institution: University of Ottawa
Session: Fall 2024
Language: Java
Project Type: Academic – Educational Purpose


The Novigrad project was designed as a practical introduction to software development and teamwork, reinforcing theoretical concepts through the creation of a functional municipal service management system.

---

## ⚖️ License & Acknowledgments
```bash
© 2024 Decaho Gbegbe – University of Ottawa
This project was created for educational purposes only as part of a university course.
Commercial use, redistribution, or modification without written permission is prohibited.

Some assets, icons, or templates may be used under open-source or fair use licenses.
All trademarks and names belong to their respective owners.
```
---

💡 “Novigrad isn’t just a city — it’s a training ground for future software engineers.”
