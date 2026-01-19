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
- MySQL Support (optional)
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Running the Application

1. Navigate to the project directory:
```bash
cd bookstore
```

2. Run using Maven:
```bash
./mvnw spring-boot:run
```

Or on Windows:
```bash
mvnw.cmd spring-boot:run
```

3. The application will start on `http://localhost:8080`

### H2 Console

Access the H2 database console at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:bookstoredb`
- Username: `sa`
- Password: (leave empty)

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

## Sample API Requests

### Create a Book

```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Effective Java",
    "author": "Joshua Bloch",
    "isbn": "978-0134685991",
    "price": 45.99,
    "stockQuantity": 25,
    "description": "Best practices for Java programming",
    "category": "Programming",
    "publisher": "Addison-Wesley",
    "publicationYear": 2018
  }'
```

### Create a Customer

```bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Alice",
    "lastName": "Williams",
    "email": "alice.williams@example.com",
    "phone": "+1555666777",
    "address": "321 Elm St",
    "city": "Boston",
    "country": "USA",
    "postalCode": "02101"
  }'
```

### Create an Order

```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerId": 1,
    "items": [
      {
        "bookId": 1,
        "quantity": 2
      },
      {
        "bookId": 3,
        "quantity": 1
      }
    ],
    "shippingAddress": "123 Main St, New York, USA 10001"
  }'
```

### Search Books by Title

```bash
curl http://localhost:8080/api/books/search/title?title=Harry
```

### Update Order Status

```bash
curl -X PATCH "http://localhost:8080/api/orders/1/status?status=SHIPPED"
```

## Order Status Values

- `PENDING` - Order has been created
- `CONFIRMED` - Order has been confirmed
- `PROCESSING` - Order is being processed
- `SHIPPED` - Order has been shipped
- `DELIVERED` - Order has been delivered
- `CANCELLED` - Order has been cancelled

## Sample Data

The application initializes with sample data:
- 8 books (including classics and programming books)
- 3 customers

## Database Configuration

### Using H2 (Default)

The application uses H2 in-memory database by default. Data is lost when the application stops.

### Using MySQL

To use MySQL instead:

1. Create a MySQL database:
```sql
CREATE DATABASE bookstore;
```

2. Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

## Error Handling

The API returns meaningful error messages with appropriate HTTP status codes:
- `400 Bad Request` - Validation errors or insufficient stock
- `404 Not Found` - Resource not found
- `409 Conflict` - Duplicate resource (e.g., ISBN or email already exists)
- `500 Internal Server Error` - Unexpected errors

## Project Structure

```
src/main/java/com/example/bookstore/
├── config/
│   └── DataInitializer.java
├── controller/
│   ├── BookController.java
│   ├── CustomerController.java
│   └── OrderController.java
├── dto/
│   ├── BookDTO.java
│   ├── CustomerDTO.java
│   ├── OrderDTO.java
│   └── OrderItemDTO.java
├── entity/
│   ├── Book.java
│   ├── Customer.java
│   ├── Order.java
│   ├── OrderItem.java
│   └── OrderStatus.java
├── exception/
│   ├── DuplicateResourceException.java
│   ├── ErrorResponse.java
│   ├── GlobalExceptionHandler.java
│   ├── InsufficientStockException.java
│   └── ResourceNotFoundException.java
├── repository/
│   ├── BookRepository.java
│   ├── CustomerRepository.java
│   ├── OrderItemRepository.java
│   └── OrderRepository.java
├── service/
│   ├── BookService.java
│   ├── CustomerService.java
│   └── OrderService.java
└── BookstoreApplication.java
```

## License

This is a demo project for educational purposes.

