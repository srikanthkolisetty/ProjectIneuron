package com.example.dto;

import com.example.annotations.Unique;

import jakarta.persistence.Column; 
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerVo {
	
	@NotNull(message = "name is required")
	@Size(min = 3, message = "Minimum 3 charaters required")
	private String name;
	@NotNull(message = "please enter your age")
	@Min(value = 18)
	private String age;
	@NotNull(message = "please select your gender")
	private String gender;
	@NotNull(message = "please select your address")
	@Size(min = 5, message = "Address must contain atleast 5 characters")
	private String address;
	@NotNull(message = "please enter your phoneNumber")
	@Size(min=10,max=10, message = "Phone number must be 10 digit")
	private String phoneNumber;
	@NotNull(message = "please enter your UserName ")
	@Size(min = 4, message = "Username must contain atleast 4 characters")
	@Unique(message="username already exists")
	private String userName;
	@NotNull(message = "please enter your password")
	 @Size(min = 6, max = 12, message = "Password must contain 6-12 characters")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
