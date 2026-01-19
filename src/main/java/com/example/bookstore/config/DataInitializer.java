package com.example.bookstore.config;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize some sample books
        if (bookRepository.count() == 0) {
            bookRepository.save(new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565",
                    new BigDecimal("10.99"), 50,
                    "The story of the mysteriously wealthy Jay Gatsby and his love for Daisy Buchanan.",
                    "Fiction", "Scribner", 1925));

            bookRepository.save(new Book(null, "To Kill a Mockingbird", "Harper Lee", "978-0061120084",
                    new BigDecimal("12.99"), 45,
                    "A gripping tale of racial injustice and childhood innocence in the American South.",
                    "Fiction", "HarperCollins", 1960));

            bookRepository.save(new Book(null, "1984", "George Orwell", "978-0451524935",
                    new BigDecimal("13.99"), 60,
                    "A dystopian novel set in Airstrip One, depicting a world of perpetual war and omnipresent government surveillance.",
                    "Science Fiction", "Signet Classic", 1949));

            bookRepository.save(new Book(null, "Pride and Prejudice", "Jane Austen", "978-0141439518",
                    new BigDecimal("9.99"), 40,
                    "The romantic clash between the opinionated Elizabeth and her proud beau, Mr. Darcy.",
                    "Romance", "Penguin Classics", 1813));

            bookRepository.save(new Book(null, "The Catcher in the Rye", "J.D. Salinger", "978-0316769174",
                    new BigDecimal("11.99"), 35,
                    "The story of teenager Holden Caulfield's experiences in New York City.",
                    "Fiction", "Little, Brown and Company", 1951));

            bookRepository.save(new Book(null, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427",
                    new BigDecimal("14.99"), 100,
                    "The magical adventure of Harry Potter begins at Hogwarts School of Witchcraft and Wizardry.",
                    "Fantasy", "Scholastic", 1997));

            bookRepository.save(new Book(null, "The Hobbit", "J.R.R. Tolkien", "978-0547928227",
                    new BigDecimal("15.99"), 55,
                    "Bilbo Baggins' journey to the Lonely Mountain with a group of dwarves to reclaim their treasure.",
                    "Fantasy", "Houghton Mifflin Harcourt", 1937));

            bookRepository.save(new Book(null, "Clean Code", "Robert C. Martin", "978-0132350884",
                    new BigDecimal("42.99"), 30,
                    "A handbook of agile software craftsmanship.",
                    "Programming", "Prentice Hall", 2008));

            System.out.println("Sample books initialized!");
        }

        // Initialize some sample customers
        if (customerRepository.count() == 0) {
            customerRepository.save(new Customer(null, "John", "Doe", "john.doe@example.com",
                    "+1234567890", "123 Main St", "New York", "USA", "10001", null, null));

            customerRepository.save(new Customer(null, "Jane", "Smith", "jane.smith@example.com",
                    "+0987654321", "456 Oak Ave", "Los Angeles", "USA", "90001", null, null));

            customerRepository.save(new Customer(null, "Bob", "Johnson", "bob.johnson@example.com",
                    "+1122334455", "789 Pine Rd", "Chicago", "USA", "60601", null, null));

            System.out.println("Sample customers initialized!");
        }
    }
}

