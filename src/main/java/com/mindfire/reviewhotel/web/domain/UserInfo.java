/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.web.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 * 
 * UserInfo Class is used as Entity Class for user details.
 */
@Entity
@Table(name = "UserInfo")
@NamedNativeQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "user_name", nullable = false, unique=true)
	private String userName;

	@Column(name = "user_email", nullable = false, unique = true)
	private String userEmail;

	@Column(nullable = false)
	private String password;

	private String role;

	@Column(name = "created_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createDate;

	public Long getId() {
		return id;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
