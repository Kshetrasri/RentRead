package com.example.rentread.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentread.entity.Book;
import com.example.rentread.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	  public List<Book> getAllAvailableBooks() {
	        return bookRepository.findByAvailabilityStatus(true);
	    }

}
