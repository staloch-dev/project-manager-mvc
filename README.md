# Product Manager MVC Application

## 🛠️ Project Overview
This project is a simple CRUD (Create, Read, Update, Delete) system developed using the **Spring Boot MVC** pattern.

It fulfills the requirements of the "MVC Architecture & Git Versioning Activity" for the Systems Development course.

The system manages a single entity: **Product**.

## 🚀 Technologies Used
* **Build Tool:** Maven 
* **Language:** Java 17+
* **Framework:** Spring Boot 3.5.7 LTS
* **Dependencies:**
    * Spring Web (Controller/REST)
    * Spring Data JPA (Persistence)
    * H2 Database (In-Memory Database)
    * Thymeleaf (View Layer)
    * Lombok (Reduced Boilerplate)
    * Validation (Business Logic)
    * Spring Boot DevTools (Developer Experience)

## ✨ Key Feature / Logic
The Product entity will include a simple **validation** and will demonstrate the ability to list, create, edit, and delete items.

## ⚙️ Development Structure
The project follows the standard MVC structure:
* `Model` (Product.java)
* `Repository` (ProductRepository.java)
* `Controller` (ProductController.java)
* `View` (Thymeleaf HTML Templates)

---

### 📝 Git History
This project requires a minimum of 4 commits:
1.  **Initial Setup** (Base structure and dependencies)
2.  **Model & Repository** Implementation
3.  **Controller & Service** Implementation
4.  **View** Implementation (Thymeleaf Templates)
