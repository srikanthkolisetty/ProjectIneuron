package com.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerPolicy {
    
    @Column(name = "cust_id")
    private Integer custId;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cpid;
    public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Double getSumAssuredNeeded() {
		return sumAssuredNeeded;
	}

	public void setSumAssuredNeeded(Double sumAssuredNeeded) {
		this.sumAssuredNeeded = sumAssuredNeeded;
	}

	public Integer getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(Integer noOfYears) {
		this.noOfYears = noOfYears;
	}

	public String getPremiumPaymentCycle() {
		return premiumPaymentCycle;
	}

	public void setPremiumPaymentCycle(String premiumPaymentCycle) {
		this.premiumPaymentCycle = premiumPaymentCycle;
	}

	public Double getCalculatedPremium() {
		return calculatedPremium;
	}

	public void setCalculatedPremium(Double calculatedPremium) {
		this.calculatedPremium = calculatedPremium;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Column(name = "policy_number")
    private Integer policyNumber;
    @Column(name = "policy_name")
    private String policyName;
    @Column(name = "sum_assured_needed")
    private Double sumAssuredNeeded;
    @Column(name = "no_of_years")
    private Integer noOfYears;
    @Column(name = "premium_payment_cycle")
    private String premiumPaymentCycle;
    @Column(name = "calculated_premium")
    private Double calculatedPremium;
    
    
    public CustomerPolicy() {

    }

    public CustomerPolicy(Integer cust_id, Integer cpid, Integer policy_number, String policy_name, Double sum_assured_needed, Integer no_of_years, String premium_payment_cycle, Double calculated_premium) {
        this.custId = cust_id;
        this.cpid = cpid;
        this.policyNumber = policy_number;
        this.policyName = policy_name;
        this.sumAssuredNeeded = sum_assured_needed;
        this.noOfYears = no_of_years;
        this.premiumPaymentCycle = premium_payment_cycle;
        this.calculatedPremium = calculated_premium;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

   

   
    
}
