package com.gymnasium.FitnessRM.models;

import java.time.LocalDate;
 
import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
public class AttendenceResponse {
    private String date;
    private String name;
    private String mobile;
	public AttendenceResponse( String name, String mobile ,String date) {
		 
		this.date = date;
		this.name = name;
		this.mobile = mobile;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
     
}
 