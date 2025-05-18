package com.travel_tales.voyage_engine.repository;



import com.travel_tales.voyage_engine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel_tales.voyage_engine.entity.Group;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group, Long>{
    List<Group> findByOwner(User owner);
}
