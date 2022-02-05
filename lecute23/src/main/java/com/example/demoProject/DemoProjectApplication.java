package com.example.demoProject;

import com.example.demoProject.model.Book;
import com.example.demoProject.model.Orders;
import com.example.demoProject.model.User;
import com.example.demoProject.repositories.BookRepository;
import com.example.demoProject.repositories.OrdersRepository;
import com.example.demoProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}


	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	OrdersRepository ordersRepository;

	@Bean
	public void create(){
		Book book = new Book("name",20f);
		User user = new User("User","address");

		book = bookRepository.save(book);
		user = userRepository.save(user);

		Orders orders = new Orders();
		orders.setBook(book);
		orders.setUser(user);
		orders = ordersRepository.save(orders);

	}
}

