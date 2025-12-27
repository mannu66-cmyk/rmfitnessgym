package com.gymnasium.FitnessRM.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AttendenceDTO {
    private String mobile;
    private String pin;
    
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

}
