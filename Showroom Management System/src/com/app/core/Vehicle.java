package com.app.core;
import java.util.Date;
import java.time.LocalDate;
public class Vehicle 

{

	private String chasisNo;
	private Color vehicleClr;
	private double basePrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean available;
	
	public Vehicle( String chasisNo) 
	{
		super();
		this.chasisNo=chasisNo;
	}
	public Vehicle(String chasisNo,Color clr,double basePrice,LocalDate manuDate,String company)
	{
		super();
		this.chasisNo = chasisNo;
		this.vehicleClr = vehicleClr;
		this.basePrice = basePrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.available = true;
		
	}
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleClr=" + vehicleClr + ", netPrice="
				+ (basePrice + vehicleClr.getAdditionalCost()) + ", manufactureDate=" + manufactureDate + ", company="
				+ company + ", available=" + available + "]";
	}
	
	public boolean equals(Object o)
	{
		System.out.println("in vehicle's eq");
		if(o instanceof Vehicle)
		{
			Vehicle anotherVehicle=(Vehicle)o;
			return this.chasisNo.equals(anotherVehicle.chasisNo);
		}
		return false;
	}
	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	
}
