package com.gymnasium.FitnessRM.models;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberResponse {

    private String name;
    private String mobile;
    private String plan;
    private String status;
    private LocalDate expiryDate;
	 
	public MemberResponse(String name, String mobile, String plan, String status, LocalDate expiryDate) {
		 
		this.name = name;
		this.mobile = mobile;
		this.plan = plan;
		this.status = status;
		this.expiryDate = expiryDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
    
    
}
