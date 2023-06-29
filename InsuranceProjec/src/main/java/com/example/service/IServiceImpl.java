package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Customer;
import com.example.dto.CustomerPolicy;
import com.example.dto.CustomerVo;
import com.example.dto.Policy;
import com.example.repo.CustomerPolicyRepo;
import com.example.repo.CustomerRepo;
import com.example.repo.PolicyRepo;
@Service
public class IServiceImpl implements IService{

	@Autowired
	private CustomerPolicyRepo rep1;
	
	@Autowired
	private CustomerRepo rep2;
	
	@Autowired
	private PolicyRepo rep3;
	
	@SuppressWarnings("deprecation")
	@Override
	public Customer getCustomerByCid(int cid) {
		// TODO Auto-generated method stub
		return rep2.getById(cid);
	}

	@Override
	public Customer getCustomerByUsername(String unm) {
		// TODO Auto-generated method stub
		return rep2.getByUsername(unm);
	}

	@Override
	public void addPolicy(Policy p) {
		// TODO Auto-generated method stub
		 rep3.save(p);
	}

	@Override
	public List<Policy> viewAllPolicy() {
		// TODO Auto-generated method stub
		return rep3.findAll();
	}

	@Override
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		rep2.save(c);
	}

	@Override
	public Policy getPolicy(CustomerPolicy cp) {
		// TODO Auto-generated method stub
		return rep3.findByPolicyName(cp.getPolicyName()).get(0);
	}

	@Override
	public CustomerPolicy applyPolicy(int cid, CustomerPolicy cp) {
		// TODO Auto-generated method stub
		List<Policy> p1 = rep3.findByPolicyName(cp.getPolicyName());
		 int pay_cycle = 1;
		 for(Policy p: p1){
	            if((cp.getSumAssuredNeeded() <= p.getMaxSumAssured()) && (cp.getNoOfYears() <= p.getMaxNoOfYears())){
	                cp.setPolicyNumber(p.getSchemeNumber());
	                
	                if(cp.getPremiumPaymentCycle().equals("Quarterly")){
	                    pay_cycle = 4;
	                }
	                else if(cp.getPremiumPaymentCycle().equals("Monthly")){
	                    pay_cycle = 12;
	                }
	                double annual_premium = ((cp.getSumAssuredNeeded()*p.getPremiumRate())/100000)*cp.getNoOfYears();
	                cp.setCalculatedPremium(annual_premium/pay_cycle);
	                return cp;
	            }
	        }
	       return null;
	}

	@Override
	public List<CustomerPolicy> viewPoliciesForCustomer(int cid) {
		// TODO Auto-generated method stub
		return rep1.findByCustId(cid);
		
	}

	@Override
	public boolean validateUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		Customer customer = rep2.getByUsernameAndPassword(uname,pwd);
		return customer!=null? true:false;
	}

	@Override
	public Policy viewPolicyDetails(int sno) {
		// TODO Auto-generated method stub
		return rep3.findById(sno).get();
	}

	@Override
	public void applyPolicyForCustomer(Customer c, CustomerPolicy p) {
		// TODO Auto-generated method stub
		rep2.save(c);
	}

	@Override
	public CustomerPolicy getCustomerPolicy(int cpid) {
		// TODO Auto-generated method stub
		return rep1.findById(cpid).get();
	}
	
	@Override
	 public boolean addPolicyForCustomer(Integer cid, CustomerPolicy cp){
	        Customer c = rep2.findById(cid).get();
	        CustomerPolicy custPolicy =applyPolicy(cid, cp);
	        if(custPolicy!=null){
	            custPolicy.setCustId(cid);
	            c.addCustomerPolicy(custPolicy);
	            applyPolicyForCustomer(c,custPolicy);
	            return true;
	        }
	        else{
	            return false;
	        }
	        
	    }

	@Override
	public String register(CustomerVo cu) {
		// TODO Auto-generated method stub
		Customer c= new Customer();
		c.setCustomerAddress(cu.getAddress());
		c.setCustomerAge(cu.getAge());
		c.setCustomerGender(cu.getGender());
		c.setCustomerName(cu.getName());
		c.setCustomerPhoneno(cu.getPhoneNumber());
		c.setUsername(cu.getUserName());
		c.setPassword(cu.getPassword());
		c.setCustomerPolicies(null);
		rep2.save(c);
		return "object saved";
	}

	@Override
	public boolean exist(String username) {
		// TODO Auto-generated method stub
		Customer byUsername = rep2.getByUsername(username);
		if(byUsername!=null && username.equals(byUsername.getUsername()))
		{
			return false;
		}
		return true;
	}

	    

}
