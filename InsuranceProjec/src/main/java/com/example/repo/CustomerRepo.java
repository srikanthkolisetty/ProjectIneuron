package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
	public Customer getByUsername(String uname);
	public Customer getByUsernameAndPassword(String uname,String pass);
}
