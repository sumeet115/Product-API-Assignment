# Spring Boot Product API

This is a Spring Boot application that provides a RESTful API for managing products. It uses Spring Data JPA for database interactions and Springdoc OpenAPI for API documentation.

## Requirements

- Java 21
- Maven
- H2 Database (in-memory)

## Getting Started

### 1. Build the project

```bash
mvn clean install
```

### 2. Run the application
```bash
mvn spring-boot:run
```

### 3. Access the h2 conssole

The H2 console is available at http://localhost:8080/h2-console.

Use the following credentials to log in:

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: password


### 3. Access the Swagger UI

The Swagger UI is available at http://localhost:8080/swagger-ui.html. This interface allows you to interact with the API endpoints.

#### API Endpoints
1. GET /products: Retrieve all products
2. GET /products/{id}: Retrieve a product by ID
3. POST /products: Create a new product
4. PUT /products/{id}: Update an existing product by ID
5. DELETE /products/{id}: Delete a product by ID

##### Sample JSON

```json
{
    "id": "1",
    "name": "Fireboult Smartwatch",
    "description": "Smartwatch",
    "price": "10",
    "quantity": "5"
}
```

## Production Readiness TODO

To make this project production-ready, consider the following improvements:

1. **Security Configuration**: Implement security measures such as authentication and authorization, especially if exposing APIs publicly.

2. **Logging**: Enhance logging configuration to capture relevant information for debugging and monitoring purposes.

3. **Error Handling**: Implement robust error handling and validation mechanisms for API inputs.

4. **Database Configuration**: Use a production-grade database like PostgreSQL, MySQL, or SQL Server instead of H2 in-memory database.

5. **Environment-specific Configurations**: Manage application properties and configurations separately for different environments (development, testing, production).

6. **Testing**: Add unit tests to cover more scenarios and add integration tests. Consider using tools like JUnit and Mockito for testing.


