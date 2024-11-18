package com.travel_tales.voyage_engine.service;

import com.travel_tales.voyage_engine.entity.User;

public interface UserService {
	
	User createUser(User user);
	User updateUser(User user, Long userId);
	User getUserById(Long userId);

}
