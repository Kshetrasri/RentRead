package com.example.rentread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentread.entity.Book;
import com.example.rentread.service.BookService;

import java.util.List;

@SpringBootApplication
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllAvailableBooks());
	}

	@PostMapping("/books")
	public ResponseEntity<Book> createBooks(Book book) {
		return ResponseEntity.ok(bookService.addBook(book));
	}

}
