package com.example.rentread.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity

@Builder
@Table(name = "rents")
public class Rent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Book book;

	@CreationTimestamp
	private LocalDate rentalDate;

	@UpdateTimestamp
	private LocalDate returnDate;
	
	

	public Rent(User user2, Book book2, LocalDate now) {
		this.user=user2;
		this.book=book2;
		this.rentalDate=now;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public LocalDate getRentalDate() {
		return rentalDate;
	}



	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}



	public LocalDate getReturnDate() {
		return returnDate;
	}



	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}



	@Override
	public String toString() {
		return "Rent [id=" + id + ", user=" + user + ", book=" + book + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + "]";
	}

	

}
