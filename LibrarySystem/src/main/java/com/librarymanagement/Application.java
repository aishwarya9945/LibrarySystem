package com.librarymanagement;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.librarymanagement.entity.Author;
import com.librarymanagement.entity.Book;
import com.librarymanagement.entity.Borrower;
import com.librarymanagement.entity.Category;
import com.librarymanagement.entity.Publisher;
import com.librarymanagement.entity.Role;
import com.librarymanagement.entity.User;
import com.librarymanagement.repository.UserRepository;
import com.librarymanagement.service.BookService;
import com.librarymanagement.util.JwtUtil;


@SpringBootApplication
@ComponentScan(basePackages = {"com.librarymanagement"})
public class Application {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	 public JwtUtil jwtUtil() {
	 return new JwtUtil();
 }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate() {
		return (args) -> {

			var book = new Book("AB1", "Spring ", "ABC1", "Spring Description");
			book.addAuthors(new Author("Matt", "Test Description"));
			book.addCategories(new Category("Dummy categary"));
			book.addPublishers(new Publisher("Publisher 1"));
			book.addBorrowers(new Borrower("Ram"));
			bookService.createBook(book);

			var book1 = new Book("CD1", "Spring Microservices", "DEF1", "Microservices Description1");
			book1.addAuthors(new Author("Maxwell", "Test Description 1"));
			book1.addCategories(new Category("New category"));
			book1.addPublishers(new Publisher("Publisher 2"));
			book1.addBorrowers(new Borrower("Raj"));
			bookService.createBook(book1);

			var book2 = new Book("EF1", "Spring Boot", "GHI1", "Spring Boot Description");
			book2.addAuthors(new Author("Josh Lang", "Test Description2"));
			book2.addCategories(new Category("Spring category"));
			book2.addPublishers(new Publisher("Publisher3"));
			book2.addBorrowers(new Borrower("Ravi"));
			bookService.createBook(book2);

			var user = new User("admin", "admin", "abc@gmail.com", passwordEncoder.encode("Abc"),
					Arrays.asList(new Role("ROLE_ADMIN")));
			userRepository.save(user);

		};
	}
}