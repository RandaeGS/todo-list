package com.example.springbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private boolean isCompleted;
	private boolean isDeleted;
	@ManyToOne
	private User user;

	public Task(String description) {
		this.description = description;
		this.isCompleted = false;
		this.isDeleted = false;
	}
}
