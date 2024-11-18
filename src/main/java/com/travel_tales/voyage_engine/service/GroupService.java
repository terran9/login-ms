package com.travel_tales.voyage_engine.service;

import com.travel_tales.voyage_engine.dto.GroupRequest;
import com.travel_tales.voyage_engine.entity.Group;

public interface GroupService {
	
	public Group createGroup(GroupRequest groupRequest, String username);

}
