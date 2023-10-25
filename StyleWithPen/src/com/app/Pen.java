package com.app;

import java.time.LocalDate;

import enums.Brand;
import enums.Material;

public class Pen {
	
	private int id;
	private Brand brand;
	private String color;
	private String inkColor;
	private Material material;
	private int stock; // quantity of available pens
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private int price;
	private int discount;
	
	static int idGenerator;
	
	static{
		idGenerator=0;
	}
	
	
// overloaded constructor for PK
	public Pen(Brand brand) {
		this.brand = brand;
	}

// getter for brand
	public Brand getBrand()
	{
		return this.brand;
	}

// setter for discount
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	// update stock for specific pen
	public void updateStock(int quantity) {
		this.stock += stock;
	}

	public void setStockUpdateDate(LocalDate date){
		this.stockUpdateDate = date;
	}
	
	// get stock update date
	public LocalDate getStockUpdateDate(){
		return this.stockUpdateDate;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate="
				+ stockListingDate + ", price=" + price + ", discount=" + discount + "]";
	}

	public Pen(Brand brand, String color, String inkColor, Material material, int stock,LocalDate stockListingDate, int price) {
		super();
		this.id = ++idGenerator;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockUpdateDate = stockListingDate;
		this.stockListingDate = stockListingDate;
		this.price = price;
	}
	
	@Override
	public boolean equals(Object O)
	{
		return this.brand.equals(((Pen)O).getBrand());
	}
}
