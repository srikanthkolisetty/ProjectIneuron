package com.example.controllers;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.Customer;
import com.example.dto.CustomerPolicy;
import com.example.dto.CustomerVo;
import com.example.dto.Policy;
import com.example.service.IService;

import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private IService appService;
	 // RETURNS THE HOME PAGE
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model map)
    {  
    	CustomerVo po = new CustomerVo();
       map.addAttribute("customer",po);
    	
    	return "customerRegPage";
    }
    
    @PostMapping("/signupData")
    public String signupData(@Valid  @ModelAttribute("customer") CustomerVo cu,BindingResult bindingResult,Model map)
    {
    	System.out.println(bindingResult.hasErrors());
    	  if(bindingResult.hasErrors()){
              return "customerRegPage";
          }
    	  
    	appService.register(cu);
    	return "userLogin";
    }
    // RETURNS THE ADMIN LOGIN PAGE
    @GetMapping("/adminLogin")
    public String getAdminLoginPage(){
        return "adminLogin";
    }

    // RETURNS THE CUSTOMER LOGIN PAGE
    @GetMapping("/userLogin")
    public String getUserLoginPage(){
        return "userLogin";
    }

    // AUTHENTICATES BOTH ADMIN AND CUSTOMER LOGIN DETAILS HERE
    @GetMapping("/authenticate")
    public String authenticateLogin(@RequestParam(value = "uname", required = false) String uname, @RequestParam(value = "pwd", required = false) String pwd, Model map){
        
        if(uname.equals("user_admin")){
            if(uname.length()>0 && pwd.length()>0  && uname.equals("user_admin") && pwd.equals("pass_admin")){     
                return "admin";
            }
            else{
                return "invalidLogin";
            }
        }
        else{
            boolean rs = appService.validateUser(uname, pwd);   // VALIDATING THE USER
            if(rs){
                map.addAttribute("username",uname);
                return "customer";
            }
            else{
                return "invalidLogin";  
            }
        }
        
    }
    
    // RETURNS ADD POLICY PAGE FOR ADMIN
    @GetMapping("/addPolicyPage")
    public String addPolicyPage(Model map){
        Policy po = new Policy();
        map.addAttribute("policyObject",po);
        return "addPolicyPage";
    }
    
    // ADDS THE POLICY TO DB IF VALID
    @PostMapping(value = "/addPolicy")
    public String addPolicy(@Valid @ModelAttribute("policyObject") Policy p, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return "addPolicyPage";
        }
        else{
            appService.addPolicy(p);
            return "addPolicySuccess";
        }
        
    }
    
    // RETURNS ALL POLICY SCHEMES CREATED
    @GetMapping(value = "/viewAllPolicyPage")
    public String viewAllPolicyPage(Model map){
        List<Policy> policies = appService.viewAllPolicy(); 
        map.addAttribute("policies", policies);
        return "policyList";
    }
    
    // RETURNS CUSTOMER REGISTRATION PAGE FOR ADMIN
    @GetMapping(value = "/addCustomerPage")
    public String addCustomerPage(Model map){
        CustomerVo co = new CustomerVo();
        map.addAttribute("customer",co);
        return "customerRegPage";
    }
    
    // ADDS THE CUSTOMER RECORD TO DB IF VALID
    @PostMapping(value = "/addCustomer")
    public String addCustomer(@Valid @ModelAttribute("customerObject") Customer c,BindingResult bindingResult,Model map ){
        
        if(bindingResult.hasErrors()){
            return "customerRegPage";
        }
        else{
            appService.addCustomer(c);
            return "addCustomerSuccess";
        }
        
    }
    
    // RETURNS THE APPLY POLICY PAGE FOR CUSTOMER
    @GetMapping(value = "/applyPolicyPage/{username}")
    public String applyPolicyPage(@PathVariable String username, Model map){
        
        Customer c = appService.getCustomerByUsername(username);
        map.addAttribute("cid", c.getCustomerId());
        CustomerPolicy cpo = new CustomerPolicy();
        map.addAttribute("customerPolicyObject", cpo);
        
        List<Policy> polList = appService.viewAllPolicy();
        map.addAttribute("polList",polList);
        return "PolicyPage";
    }
    
    // APPLIES THE NEW POLICY FOR THE CUSTOMER
    @PostMapping(value = "/applyPolicy/{cid}")
    public String applyPolicy(@PathVariable int cid, @ModelAttribute("customerPolicyObject") CustomerPolicy cp, Model map){
        
        boolean rs = appService.addPolicyForCustomer(cid,cp);
        map.addAttribute("username",appService.getCustomerByCid(cid).getUsername());
        if(rs){
            return "applyPolicySuccess";
        }
        else{
            return "applyPolicyFail";
        }
    }
    
    // RETURNS THE CUSTOMER POLICY PAGE FOR ADMIN
    @GetMapping(value = "/customerPolicyPage")
    public String customerPolicyPage(){
        return "customerPolicyPage";
    }
    
    
    // RETURNS ALL THE POLICY SCHEMES APPLIED BY A CUSTOMER
    @GetMapping(value = "/viewPoliciesForCustomer/{cid}")
    public String viewPoliciesForCustomer(@PathVariable int cid, Model map){
        
        Customer c1 = appService.getCustomerByCid(cid);
        if(c1!=null){
            List<CustomerPolicy> cplist = c1.getCustomerPolicies();
            map.addAttribute("cname", c1.getCustomerName());
            map.addAttribute("policiesForCustomerList", cplist);
            return "policyCustomerList";
        }
        else{
            map.addAttribute("cid",cid);
            return "customerNotFound";
        }
    }
    
    // RETURNS POLICY DETAILS PAGE FOR THE CUSTOMER
    @GetMapping(value = "/viewPolicyDetailsPage")
    public String viewPolicyDetailsPage(Model map){
        List<Policy> pl = appService.viewAllPolicy();
        map.addAttribute("allpolicies",pl);
        return "policyDetailsPage";
    }
    
    // RETURNS POLICY DETAILS
    @GetMapping(value = "/viewPolicyDetails/{sno}")
    public String viewPolicyDetails(@PathVariable int sno, Model map){
        Policy p1 = appService.viewPolicyDetails(sno);
        List<Policy> pl = new ArrayList<>();
        pl.add(p1);
        map.addAttribute("policyDetailsObject", pl);
        return "policyDetails";
    }
    
    // RETURNS THE PREMIUM PAID PAGE FOR THE CUSTOMER WITH LIST OF POLICIES APPLIED 
    @GetMapping("/getPremiumPage/{username}")
    public String getPremiumPage(@PathVariable String username, Model map){
        Customer c = appService.getCustomerByUsername(username);
        List<CustomerPolicy> cplist = c.getCustomerPolicies();
        map.addAttribute("policiesForCustomerList", cplist);
        return "policyCustomerListPremium";
    }
    
    // RETURNS THE PAGE WITH CALCULATED PREMIUM FOR A POLICY APPLIED BY THE CUSTOMER
    @GetMapping(value = "/getPremium/{cpid}")
    public String getPremium(@PathVariable int cpid, Model map){
        CustomerPolicy cp = appService.getCustomerPolicy(cpid);
        Customer c = appService.getCustomerByCid(cp.getCustId());
        List<CustomerPolicy> cl = new ArrayList<>();
        cl.add(cp);
        map.addAttribute("custpolicyobject", cl);
        map.addAttribute("custobject", c);
        return "customerPremiumPage";
    }
    
    @PostMapping("/customerData")
    public String view(@RequestParam String name,Model map)
    {
    	Customer username = appService.getCustomerByUsername(name);
    	List<CustomerPolicy> viewPoliciesForCustomer=null;
    	if(username!=null)
    		viewPoliciesForCustomer = appService.viewPoliciesForCustomer(username.getCustomerId());
    	map.addAttribute("list",viewPoliciesForCustomer);
    	
    	return "view";
    }
}
