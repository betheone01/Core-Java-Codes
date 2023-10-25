package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.List;

import com.app.Pen;

import enums.Brand;
import enums.Material;
import exception_handling.penExceptions;

public class penValidationRules{

	// validate Brand
	public static Brand parseAndValidateBrand(String brand) throws IllegalArgumentException
	{
		return Brand.valueOf(brand.toUpperCase());
	}
	
	//validate Material
	public static Material parseAndValidateMaterial(String material) throws IllegalArgumentException
	{
		return Material.valueOf(material.toUpperCase());
	}
	
	//validate stock listing date
	public static LocalDate parseAndValidateListingDate(String stockListingDate) throws DateTimeParseException
	{
		return LocalDate.parse(stockListingDate);
	}
	
	// validate all inputs
	public static Pen validateAllInputs(String brand, String color, String inkColor, String material, int stock,String stockListingDate, int price)
	{
		Brand validatedBrand = parseAndValidateBrand(brand);
		Material validatedMaterial = parseAndValidateMaterial(material);
		LocalDate validatedDate = parseAndValidateListingDate(stockListingDate);
		
		//passsing all args to constructor and return new Pen
		//Brand brand, String color, String inkColor, Material material, int stock,LocalDate stockListingDate, int price
		
		return new Pen(validatedBrand, color, inkColor, validatedMaterial, stock, validatedDate, price);
	}
	
	// update pen stock
	public static void updatePenStock(String brand, int quantity, List<Pen> pens) throws penExceptions
	{
		System.out.println("Enter brand name:");
		Brand validatedBrand = parseAndValidateBrand(brand);
		
		Pen p = new Pen(validatedBrand);
		
		if(pens.contains(p)){
			int index = pens.indexOf(p);
			pens.get(index).updateStock(quantity);
			pens.get(index).setStockUpdateDate(LocalDate.now());
			System.out.println("stock updated");
		}
		else {
			throw new penExceptions("Pen with specified Brand not found!");
		}
	}
	
	public static void setDiscount(List<Pen>pens) {
		for(Pen p : pens)
		{
			if(p.getStockUpdateDate().isBefore(LocalDate.now().minusMonths(3))){
				p.setDiscount(20);
				System.out.println("discount of 20% applied for"+ p.getBrand());
			}
		}
	}
	
	public static void removeOldPens(List<Pen> pens) {
		
		Iterator<Pen>  itr = pens.iterator();
		while(itr.hasNext())
		{
			Pen p =itr.next();
			if(p.getStockUpdateDate().isBefore(LocalDate.now().minusMonths(9)))
			{
				itr.remove();
				System.out.println(p.getBrand()+ " removed");
			}
		}
		
	}
}
