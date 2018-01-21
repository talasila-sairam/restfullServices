package com.injections.beanparam.resources;

import java.util.List;

import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class Apartment {
	public Apartment() {
		System.out.println("inside the constructor of the Apartment ");
	}
	@PathParam("location")
	private String location;
	
	@QueryParam("maxBudget")
	private double maxBudget;
	
	@QueryParam("minBudget")
	private double minBudget;
	
	@MatrixParam("area")
	private String area; 
	/*incase of rest easy only Matrix parameters it will support 
	where as jersey it will not support*/
	
	@QueryParam("aminites")
	private List<String> aminites;
	
	@QueryParam("builder")
	private String builder;
	
	@QueryParam("apartmentType")
	private String apartmentType;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getMaxBudget() {
		return maxBudget;
	}
	public void setMaxBudget(double maxBudget) {
		this.maxBudget = maxBudget;
	}
	public double getMinBudget() {
		return minBudget;
	}
	public void setMinBudget(double minBudget) {
		this.minBudget = minBudget;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public List<String> getAminites() {
		return aminites;
	}
	public void setAminites(List<String> aminites) {
		this.aminites = aminites;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}
	@Override
	public String toString() {
		return "Apartment [location=" + location + ", maxBudget=" + maxBudget + ", minBudget=" + minBudget + ", area="
				+ area + ", aminites=" + aminites + ", builder=" + builder + ", apartmentType=" + apartmentType + "]";
	}
}
