package com.example.lecture12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Lecture12Application {

	public List<String> names= new ArrayList<String>();

	public static void main(String[] args) {
		SpringApplication.run(Lecture12Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		if(name.length()<3){
			System.out.println("Name is too short");
		}
		names.add(name);
		return String.format("Hello %s!", name);
	}

	@GetMapping("/all")
	public List all() {

		return names;
	}

	@PostMapping("/hello")
	public void postHello(@RequestBody HelloExample hello){
		System.out.println(hello.getExample());


	}

	@GetMapping("/helloExample")
	public HelloExample helloExampleMethod(){
		HelloExample helloExample= new HelloExample();
		helloExample.setExample("This is demo value");
		helloExample.setNumber(5);
		helloExample.setBooleanValue(true);
		helloExample.setList(names);
		return helloExample;
	}

}
