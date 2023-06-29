package com.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "policy")
public class Policy {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "scheme_number")
    private Integer schemeNumber;

    @NotBlank(message = "name is required")
    @Size(min = 6, message = "Policy name is required")
    @Column(name = "policy_name")
    private String policyName;
    
    @NotNull(message = "policy type is required")
    @Column(name = "policy_type")
    private String policyType;

    @NotNull(message = "max years is required")
    @Min(value = 1, message = "Value must be greater than 0")
    @Column(name = "max_no_of_years")
    private Integer maxNoOfYears;

    @NotNull(message = "premium rate is required")
    @Min(value = 1, message = "Value must be greater than 0")
    @Column(name = "premium_rate")
    private Double premiumRate;

    @NotNull(message = "max sum assured is required")
    @Min(value = 1, message = "Value must be greater than 0")
    @Column(name = "max_sum_assured")
    private Double maxSumAssured;
    
    
    public Policy() {
    }

    public Policy(Integer scheme_number, String policy_name, String policy_type, Integer max_no_of_years, Double premium_rate, Double max_sum_assured) {
        this.schemeNumber = scheme_number;
        this.policyName = policy_name;
        this.policyType = policy_type;
        this.maxNoOfYears = max_no_of_years;
        this.premiumRate = premium_rate;
        this.maxSumAssured = max_sum_assured;
    }

	public Integer getSchemeNumber() {
		return schemeNumber;
	}

	public void setSchemeNumber(Integer schemeNumber) {
		this.schemeNumber = schemeNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Integer getMaxNoOfYears() {
		return maxNoOfYears;
	}

	public void setMaxNoOfYears(Integer maxNoOfYears) {
		this.maxNoOfYears = maxNoOfYears;
	}

	public Double getPremiumRate() {
		return premiumRate;
	}

	public void setPremiumRate(Double premiumRate) {
		this.premiumRate = premiumRate;
	}

	public Double getMaxSumAssured() {
		return maxSumAssured;
	}

	public void setMaxSumAssured(Double maxSumAssured) {
		this.maxSumAssured = maxSumAssured;
	}

	@Override
	public String toString() {
		return "Policy [schemeNumber=" + schemeNumber + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", maxNoOfYears=" + maxNoOfYears + ", premiumRate=" + premiumRate + ", maxSumAssured=" + maxSumAssured
				+ "]";
	}

   
    
}
