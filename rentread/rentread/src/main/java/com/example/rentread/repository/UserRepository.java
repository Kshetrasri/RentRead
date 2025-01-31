package com.example.rentread.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentread.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	 long countByUserIdAndReturnDateIsNull(Long id);

}
