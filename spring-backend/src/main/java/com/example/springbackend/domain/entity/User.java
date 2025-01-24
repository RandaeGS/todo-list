package com.example.springbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@OneToMany
	private List<Task> taskList;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
