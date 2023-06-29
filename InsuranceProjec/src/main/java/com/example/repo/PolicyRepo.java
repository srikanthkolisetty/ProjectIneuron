package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.Policy;

public interface PolicyRepo extends JpaRepository<Policy, Integer> {

	public List<Policy> findByPolicyName(String name);
}
