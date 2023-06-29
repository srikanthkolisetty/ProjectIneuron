package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.CustomerPolicy;

public interface CustomerPolicyRepo extends JpaRepository<CustomerPolicy, Integer> {

	
	public List<CustomerPolicy> findByCustId(Integer id);
}
