package com.example.service;

import java.util.List;

import com.example.dto.Customer;
import com.example.dto.CustomerPolicy;
import com.example.dto.CustomerVo;
import com.example.dto.Policy;



public interface IService {
	public Customer getCustomerByCid(int cid);
    public Customer getCustomerByUsername(String unm);
    public void addPolicy(Policy p);
    public List<Policy> viewAllPolicy();
    public void addCustomer(Customer c);
    public Policy getPolicy(CustomerPolicy cp);
    public CustomerPolicy applyPolicy(int cid, CustomerPolicy cp);
    public List<CustomerPolicy> viewPoliciesForCustomer(int cid);
    public boolean validateUser(String uname, String pwd);
    public Policy viewPolicyDetails(int sno);
    public void applyPolicyForCustomer(Customer c, CustomerPolicy p);
    public CustomerPolicy getCustomerPolicy(int cpid);
    public boolean addPolicyForCustomer(Integer c,CustomerPolicy cp);
    public String register(CustomerVo cu);
    public boolean exist(String username);
}
