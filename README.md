# Quiz-Application-For-Chruch-Community
# Overview

The "Quiz Application for Church Community" is a comprehensive software platform designed to facilitate quiz-related activities within a church or religious community. It leverages the Spring Boot framework, which provides a robust and scalable foundation for building Java-based applications.

# Technologies Used
* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Lombok (Java library that simplifies the development process by reducing boilerplate code in Java classes.)
* Maven (as the build tool)
* MySQL (or any other compatible database)

# Project Structure
The project follows a standard Spring Boot project structure:


|- src

    |- main
        |- java
            |- com.samuel.springboot_backend
                |- controller
                    |- QuestionController.java
                    |- QuizController.java
                |- model
                    |- DTO
                      |- QuestionWrapper.java
                      |- Response.java
                    |- Quiz.java
                    |- Question.java
                |- repository
                    |- QuestionRepository.java
                    |- QuizRepository.java
                |- service
                    |- Quiz
                      |- QuizService.java
                      |- QuizServiceImplementation.jav
                    |- Question
                      |- QuestionService.java
                      |- QuestionServiceImplementation.java
        |- resources
            |- application.properties



# How to Use
# Setup
* Clone the project from the repository.
* Configure the database connection in the application.properties file. Modify the following properties with your database credentials:

```
spring.datasource.url=jdbc:mysql://your_database_host:your_database_port/your_database_name  
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
```
* Provided configuration is for setting up Hibernate properties in a Spring Boot application that uses JPA for database access. Below is an explanation of each property:
    - ``` spring.jpa.properties.hibernate.dialect ``` :- This property sets the Hibernate dialect for the database being used. In this case, it is set to org.hibernate.dialect.MySQL57Dialect, which means Hibernate will use the MySQL 5.7 dialect to generate appropriate SQL statements compatible with MySQL 5.7.
    - ``` spring.jpa.hibernate.ddl-auto ``` :- This property determines how Hibernate handles the database schema during startup. The value update instructs Hibernate to update the schema automatically based on the entity classes and their mappings. If the schema does not exist, it will be created. If it already exists, Hibernate will modify the schema to match the current entity definitions while trying to preserve existing data. Be cautious when using this setting in production to avoid data loss.
  - ``` server.port ``` :- This property sets the port on which the Spring Boot application will run. In this case, the application will be accessible at http://localhost:8082.
  
##[Please ensure that you have correctly configured the MySQL database connection properties (e.g., spring.datasource.url, spring.datasource.username, spring.datasource.password, etc.) in the application.properties file to establish a successful connection with the MySQL database]

* Build the project using Maven: " mvn clean install "
* Run the Spring Boot application: " mvn spring-boot:run "


# Endpoints

* Here are the endpoints of the QuestionController along with a short description:

Create:

* **POST /api/v1/questions/single-questions* **

Creates a single question.
Request Body: Question object.
POST /api/v1/questions/all-questions

Creates multiple questions at once.
Request Body: List of Question objects.
Read:

* **GET /api/v1/questions* **

Retrieves all questions.
* **GET /api/v1/questions/category/{category}* **

Retrieves questions by category.
Path Variable: category.
* **GET /api/v1/questions/{id}* **

Retrieves a question by its ID.
Path Variable: id.
Update:

* **PUT /api/v1/questions/{id}* **
Updates a question by its ID.
Path Variable: id.
Request Body: Updated Question object.
Delete:

* **DELETE /api/v1/questions/{id}* **
Deletes a question by its ID.
Path Variable: id.
Please note that the commented out code for updating based on category and ID has been removed from the list of endpoints as it seems to be commented out in your code. If you want to re-enable it, you can uncomment and it will be accessible via POST /api/v1/questions/category/{id}.


* Create Quiz:

* **POST /api/v1/quiz/create* **
Creates a new quiz.
Parameters:
category: String
numberOfQuestions: int
title: String
Get Quiz Questions:

* **GET /api/v1/quiz/get/{id}* **
Retrieves questions for a specific quiz.
Path Variable: id
Submit Quiz:

* **POST /api/v1/quiz/submit/{id}* **
Submits quiz responses and calculates the result.
Path Variable: id
Request Body: List of Response objects.
These endpoints handle the creation, retrieval, and submission of quizzes

"Quiz Application for Church Community" offers an engaging and interactive platform for members of a church or religious community to enhance their knowledge and foster a sense of community through quizzes and friendly competition. Its user-friendly interface and comprehensive feature set make it a valuable tool for both administrators and participants
