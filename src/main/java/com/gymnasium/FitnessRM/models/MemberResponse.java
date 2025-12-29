package com.gymnasium.FitnessRM.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {

	private Long id;
	private String name;
	private String mobile;
	private String plan;
	private String status;
	private String pin;
	private Integer age;
	private LocalDate startDate;
	private LocalDate expiryDate;

	public MemberResponse(Long id, String name, String mobile, String plan, String status, String pin, Integer age,
			LocalDate startDate, LocalDate expiryDate) {

		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.plan = plan;
		this.status = status;
		this.pin = pin;
		this.age = age;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

}
