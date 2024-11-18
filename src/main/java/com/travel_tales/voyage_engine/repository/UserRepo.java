package com.travel_tales.voyage_engine.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel_tales.voyage_engine.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
	
}
