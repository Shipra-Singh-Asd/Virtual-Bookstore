# Virtual Bookstore - Spring Boot Application

A comprehensive REST API for a virtual bookstore built with Java and Spring Boot.

## Features

- **Book Management**: CRUD operations for books with search capabilities
- **Customer Management**: Manage customer information
- **Order Processing**: Create and manage orders with automatic inventory updates
- **Stock Management**: Track and update book inventory
- **Exception Handling**: Comprehensive error handling with meaningful messages
- **Data Validation**: Input validation using Bean Validation

## Technologies Used

- Java 17
- Spring Boot 4.0.1
- Spring Data JPA
- H2 Database (in-memory for development)
- Lombok
- Maven

## Getting Started

## API Endpoints

### Books

- **GET /api/books** - Get all books
- **GET /api/books/{id}** - Get book by ID
- **GET /api/books/isbn/{isbn}** - Get book by ISBN
- **GET /api/books/search/title?title={title}** - Search books by title
- **GET /api/books/search/author?author={author}** - Search books by author
- **GET /api/books/category/{category}** - Get books by category
- **GET /api/books/available** - Get all available books (stock > 0)
- **POST /api/books** - Create a new book
- **PUT /api/books/{id}** - Update a book
- **DELETE /api/books/{id}** - Delete a book
- **PATCH /api/books/{id}/stock?quantity={quantity}** - Update book stock

### Customers

- **GET /api/customers** - Get all customers
- **GET /api/customers/{id}** - Get customer by ID
- **GET /api/customers/email/{email}** - Get customer by email
- **POST /api/customers** - Create a new customer
- **PUT /api/customers/{id}** - Update a customer
- **DELETE /api/customers/{id}** - Delete a customer

### Orders

- **GET /api/orders** - Get all orders
- **GET /api/orders/{id}** - Get order by ID
- **GET /api/orders/customer/{customerId}** - Get orders by customer ID
- **GET /api/orders/status/{status}** - Get orders by status
- **POST /api/orders** - Create a new order
- **PATCH /api/orders/{id}/status?status={status}** - Update order status
- **DELETE /api/orders/{id}/cancel** - Cancel an order

