package com.gymnasium.FitnessRM.models;

import java.time.LocalDate;
 
import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
public class PackageResponse {
    private String date;
    private String name;
    private Integer price;
	public PackageResponse( String name, Integer price ,String date) {
		 
		this.date = date;
		this.name = name;
		this.price = price;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
     
	
}
 