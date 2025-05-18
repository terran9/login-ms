package com.travel_tales.voyage_engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.travel_tales.voyage_engine.dto.GroupRequest;
import com.travel_tales.voyage_engine.entity.Group;
import com.travel_tales.voyage_engine.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    @PreAuthorize("isAuthenticated()") // Ensure the user is logged in
    public ResponseEntity<Group> createGroup(@RequestBody GroupRequest groupRequest, Authentication authentication) {
        String username = authentication.getName();
        Group createdGroup = groupService.createGroup(groupRequest, username);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGroup);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Group>> getAllGroups(Authentication authentication){
        String username = authentication.getName();
        return ResponseEntity.status(HttpStatus.OK).body(groupService.getGroups(username));
    }
}