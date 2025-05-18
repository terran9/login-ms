package com.travel_tales.voyage_engine.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`user`")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(unique = true)
	private String emailId;
	
	private String role;
}
