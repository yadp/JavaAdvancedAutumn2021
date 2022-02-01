package com.example.lecture22;

import com.example.lecture22.model.Book;
import com.example.lecture22.model.Orders;
import com.example.lecture22.model.User;
import com.example.lecture22.repositories.BookRepository;
import com.example.lecture22.repositories.OrdersRepository;
import com.example.lecture22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lecture22Application {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lecture22Application.class, args);
	}

	@Bean
	public void createTestData(){
		User user= new User("Test", "TestAddress");
		Book book= new Book("Title",10.0f);
		user = userRepository.save(user);
		book = bookRepository.save(book);

		/*Orders orders= new Orders(user.getId(),book.getId());

		orders = ordersRepository.save(orders);

		orders.setBook(bookRepository.findById(orders.getBookid()).get());
		orders.setUser(userRepository.findById(orders.getUserid()).get());

		System.out.println(orders.getBook());
		System.out.println(orders.getUser());*/
	}
}


