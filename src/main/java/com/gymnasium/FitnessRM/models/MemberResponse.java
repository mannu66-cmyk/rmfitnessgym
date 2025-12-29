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
	private String pin;
    private Integer age;
    private LocalDate expiryDate;
	 
	public MemberResponse(String name, String mobile, String plan, String status, LocalDate expiryDate, String pin, Integer age) {
		 
		this.name = name;
		this.mobile = mobile;
		this.plan = plan;
		this.status = status;
		this.expiryDate = expiryDate;
		this.pin = pin;
		this.age = age;
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
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
