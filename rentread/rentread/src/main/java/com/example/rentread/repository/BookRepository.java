package com.example.rentread.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentread.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByAvailabilityStatus(boolean b);

}
