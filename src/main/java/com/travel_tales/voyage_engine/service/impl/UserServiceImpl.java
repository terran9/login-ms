package com.travel_tales.voyage_engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel_tales.voyage_engine.entity.User;
import com.travel_tales.voyage_engine.repository.UserRepo;
import com.travel_tales.voyage_engine.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		userRepo.save(user);
		return user;
	}

	@Override
	public User updateUser(User user, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException());
		return user;
	}

}
