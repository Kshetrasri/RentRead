package com.example.rentread.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
	import org.springframework.security.access.annotation.Secured;
	import org.springframework.web.bind.annotation.*;

import com.example.rentread.entity.Rent;
import com.example.rentread.service.RentService;

@SpringBootApplication
@RequestMapping("/books")
public class RentalController{
	
	 @Autowired
	 RentService rentalService;

	 

	    @Secured("ROLE_USER")
	    @PostMapping("/{bookId}/rent")
	    public ResponseEntity<Rent> rentBook(@PathVariable Long bookId, @RequestParam Long userId) {
	        return ResponseEntity.ok(rentalService.rentBook(userId, bookId));
	    }

	    @Secured("ROLE_USER")
	    @PostMapping("/{rentalId}/return")
	    public ResponseEntity<Rent> returnBook(@PathVariable Long rentalId) {
	        return ResponseEntity.ok(rentalService.returnBook(rentalId));
	    }
	}

