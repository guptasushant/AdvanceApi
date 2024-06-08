package com.advance.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ApiDto {
	private int id;

	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 6, message = "Name must be at least 6 characters long")
	@Pattern(regexp = "^[a-zA-Z]{6,}$", message = "Name must contain only letters and be at least 6 characters long")
	private String name;

	@NotNull(message = "Email cannot be null")
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and be at least 6 characters long")
	private String password;

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Constructors
	public ApiDto(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public ApiDto() {
		super();
	}

	@Override
	public String toString() {
		return "ApiDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}
