package com.example.pafdemo21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pafdemo21.repository.BookRepository;

@SpringBootApplication
public class Pafdemo21Application implements CommandLineRunner {

	@Autowired
	BookRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Pafdemo21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.getAllBooks();
	}
}
