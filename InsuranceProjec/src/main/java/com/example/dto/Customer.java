package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;
    
    @NotNull(message = "name is required")
    @Size(min = 3, message = "Minimum 3 charaters required")
    @Column(name = "customer_name")
    private String customerName;

    @NotNull(message = "age is required")
    @Min(value = 18)
    @Column(name = "customer_age")
    private String customerAge;

    @NotNull(message = "gender is required")
    @Column(name = "customer_gender")
    private String customerGender;

    @NotNull(message = "address is required")
    @Size(min = 5, message = "Address must contain atleast 5 characters")
    @Column(name = "customer_address")
    private String customerAddress;

    @NotNull(message = "phone no is required")
    @Size(min=10,max=10, message = "Phone number must be 10 digit")
    @Column(name = "customer_phoneno")
    private String customerPhoneno;

    @NotNull(message = "username is required")
    @Size(min = 4, message = "Username must contain atleast 4 characters")
    @Column(name = "username",unique = true)
    private String username;

    @NotNull(message = "password is required")
    @Size(min = 6, max = 12, message = "Password must contain 6-12 characters")
    @Column(name = "password")
    private String password;
    
    

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "cust_id")
    @JoinTable(name = "customerpolicy_customer", joinColumns = @JoinColumn(name = "cust_id"), inverseJoinColumns = @JoinColumn(name = "cpid"))
    List<CustomerPolicy> customerPolicies;
    
    public Customer() {
    }

    public Customer( String customer_name, String customer_age, String customer_gender, String customer_address, String customer_phoneno, String username, String password,List<CustomerPolicy> customerPolicies) {
        this.customerName = customer_name;
        this.customerAge = customer_age;
        this.customerGender = customer_gender;
        this.customerAddress = customer_address;
        this.customerPhoneno = customer_phoneno;
        this.username = username;
        this.password = password;
        this.customerPolicies = customerPolicies;
    }

    public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneno() {
		return customerPhoneno;
	}

	public void setCustomerPhoneno(String customerPhoneno) {
		this.customerPhoneno = customerPhoneno;
	}

	public List<CustomerPolicy> getCustomerPolicies() {
        return customerPolicies;
    }

    public void setCustomerPolicies(List<CustomerPolicy> customerPolicies) {
        this.customerPolicies = customerPolicies;
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
    
    
    // ADDING THE POLICY TAKEN BY CUSTOMER IN LIST
    public void addCustomerPolicy(CustomerPolicy cp){
        if(customerPolicies == null){
            customerPolicies = new ArrayList<>();
        }
        customerPolicies.add(cp);
    }

   
}
