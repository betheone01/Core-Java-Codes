package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import utils.ExceptionHandling;

import Core.Grocery;

public class ExceptionRules {
	
	public static void checkForDups(String name,HashMap<String,Grocery>items)throws ExceptionHandling
	{
		if(items.containsKey(name))
		{
			throw new ExceptionHandling("Duplicate item");
		}
		else {
			System.out.println("Not Duplicate item");
		}
	}

	public static void upadateItem(String name,int quantity,HashMap<String,Grocery>items)
	{
		
		if(items.containsKey(name))
		{
			items.get(name).setStock(quantity);
			items.get(name).setDateTime(LocalDateTime.now());
			
		}
	}
	public static LocalDateTime ValidateDate(String dateTime)
	{
		return LocalDateTime.parse(dateTime);
	}
	
	public static Grocery validAllinputs(String name, int price,int stock ,String dateTime,HashMap<String,Grocery>items) throws ExceptionHandling
	{
		checkForDups(name,items);
		LocalDateTime d=ValidateDate( dateTime);
		
		
		
		
		return new Grocery( name,  price, stock , d);
	}
}
