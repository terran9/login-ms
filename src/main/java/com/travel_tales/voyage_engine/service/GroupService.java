package com.travel_tales.voyage_engine.service;

import com.travel_tales.voyage_engine.dto.GroupRequest;
import com.travel_tales.voyage_engine.entity.Group;

import java.util.List;

public interface GroupService {
	
	public Group createGroup(GroupRequest groupRequest, String username);

    public List<Group> getGroups(String username);
}
