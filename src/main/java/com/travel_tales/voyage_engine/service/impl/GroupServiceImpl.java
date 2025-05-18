package com.travel_tales.voyage_engine.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travel_tales.voyage_engine.dto.GroupRequest;
import com.travel_tales.voyage_engine.entity.Group;
import com.travel_tales.voyage_engine.entity.User;
import com.travel_tales.voyage_engine.repository.GroupRepo;
import com.travel_tales.voyage_engine.repository.UserRepo;
import com.travel_tales.voyage_engine.service.GroupService;


@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
    private GroupRepo groupRepo;

    @Autowired
    private UserRepo userRepo;

	public Group createGroup(GroupRequest groupRequest, String username) {
		 User owner = userRepo.findByUsername(username)
		            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

		        Group group = new Group();
		        group.setName(groupRequest.getName());
		        group.setDescription(groupRequest.getDescription());
		        group.setOwner(owner);
		        group.getMembers().add(owner);
		        group.setCreatedDate(new Date());

		       return groupRepo.save(group);
	}

	@Override
	public List<Group> getGroups(String username) {
		User owner = userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return groupRepo.findByOwner(owner);
	}

}
