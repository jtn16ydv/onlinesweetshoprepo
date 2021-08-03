package com.onlinesweetshopapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "userId is required")
	@Size(min = 5, max = 10, message = "Size must be between 5 to 10 characters")
	@Column(unique = true, updatable = false)
	private String userId;
	
	@NotBlank(message = "userName is required")
	private String name;
	
	@NotBlank(message = "password is required")
	private String password;
	
	@NotBlank(message = "email is required")
	private String email;
	
	private int isLoggedIn;

	/**
	 * Admin Constructor
	 */
	public Admin() {
		super();

	}

	/**
	 * Admin Parameterized constructor
	 * 
	 * @param String userId
	 * @param String name
	 * @param String password
	 * @param String email
	 */
	public Admin(String userId, String name, String password, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	/**
	 * Gets the id
	 * 
	 * @return long id
	 */

	public long getId() {
		return id;
	}

	/**
	 * Sets the id
	 * 
	 * @param id long
	 */

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the userId
	 * 
	 * @return UserId String
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the userId
	 * 
	 * @param userId String
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the name
	 * 
	 * @return name String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * 
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password
	 * 
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * 
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the Email
	 * 
	 * @return email Strig
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email
	 * 
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the loggedInStatus
	 * 
	 * @return isLoggedIn
	 */
	public int getIsLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * Sets the loggedInStatus
	 * 
	 * @param isLoggedIn int
	 */
	public void setIsLoggedIn(int isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

}
