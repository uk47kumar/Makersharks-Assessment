# Makersharks-Assessment

Spring Boot Application with In-Memory H2 Database and Swagger Documentation

# Table of Contents

Introduction

Features

Prerequisites

Installation

Running the Application

Accessing Swagger Documentation

Database Configuration

Exception Handling


# Introduction
This is a Spring Boot application that uses an in-memory H2 database for development and testing purposes. It also includes Swagger for API documentation and testing.


# Features
Spring Boot framework

In-memory H2 database

Swagger UI for API documentation

RESTful endpoints

Comprehensive exception handling


# Prerequisites
Java 8 or higher

Maven 3.6.3 or higher


# Installation
1.Clone the repository: git clone https://github.com/uk47kumar/Makersharks-Assessment.git

cd Makersharks-Assessment

2.Build the project using Maven: mvn clean install


# Running the Application
1.Run the application using Maven: mvn spring-boot:run

2.Alternatively, you can run the application using the generated JAR file: java -jar target/your-application-name.jar


# Accessing Swagger Documentation
Once the application is running, you can access the Swagger UI at the following URL: http://localhost:8080/swagger-ui.html

This will open the Swagger interface where you can explore and test the API endpoints.


# Database Configuration
The application uses an in-memory H2 database, which is configured in the application.properties file as follows:

# H2 Database configuration
spring.datasource.url=jdbc:h2:mem:test

spring.h2.console.enabled=true

# JPA configuration
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true

# You can access the H2 database console at: 
http://localhost:8080/h2-console


# Exception Handling
The application includes comprehensive exception handling to manage various types of exceptions gracefully.

Global Exception Handling
Global exceptions are handled by the ApiException class, which manages all types of exceptions that can occur within the application. This ensures that any unexpected errors are caught and a meaningful response is provided to the client.

Resource Not Found Exception
The ResourceNotFoundException is used to handle cases where a requested resource is not found. This specific exception is caught and handled to return a 404 Not Found status along with a descriptive message.

ApiException
The ApiException class serves as a global handler for exceptions. It provides a generic structure to handle various exceptions, ensuring consistent and informative error responses.
