package com.travel_tales.voyage_engine.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.travel_tales.voyage_engine.entity.Group;

public interface GroupRepo extends JpaRepository<Group, Long>{
	
}
