E-commerce Application
This is a simple e-commerce application built using Spring Boot, H2 Database, and Spring MVC for the backend, with React used for the frontend. The application supports basic operations for managing products, including adding, deleting, updating, and searching for products using JPQL.

Features

Add Product: Add a new product to the inventory.

Delete Product: Remove a product from the inventory.

Update Product: Update the details of an existing product.

Search Product: Search for products based on certain criteria using JPQL.

Backend

Technologies Used:

Spring Boot: Backend framework.

Spring Data JPA: To interact with the database.

H2 Database: In-memory database for quick development and testing.

Spring MVC: To handle HTTP requests (GET, POST, PUT, DELETE).

How to Run

Prerequisites:

Java 17 or later

Maven

Node.js and npm (for the React frontend)


Steps to Run:

1. Clone the Repository:

git clone <repository-url>
cd simple-ecommerce-application

2. Backend Setup:

Navigate to the backend folder.
cd backend

Build the project.
mvn clean install

Run the application.
mvn spring-boot:run

3. Frontend Setup:

Navigate to the frontend folder.

cd frontend

Install dependencies.

npm install

Start the development server.
npm run dev

Access the Application:

Backend API: http://localhost:8080

Frontend: [http://localhost:3000](http://localhost:5173/product/1)

Database

The application uses an in-memory H2 Database. To access the database console:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (leave it empty)
