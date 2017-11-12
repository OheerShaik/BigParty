package com.eduworld.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class UserSignUpDto implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4481222224586890427L;
	@NotNull
	private String firstName;
	private String lastName;
	private String middleName;
	private String username;
	private String password;
	private String reTypePwd;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReTypePwd() {
		return reTypePwd;
	}
	public void setReTypePwd(String reTypePwd) {
		this.reTypePwd = reTypePwd;
	}
	
	
	

}
