package utils;
import java.time.LocalDate;
import java.util.*;
import java.util.HashMap;

import core.Book;
import core.Publication;

public class ExceptionValidationRules 
{

	
	static Scanner sc=new Scanner(System.in);
	//public static Publication validAllInputsForBook(String title,)
	
	public static Publication  addNewBook(HashMap<Integer,Publication>publications)
	{
		System.out.println("Enter the book Details ");
		System.out.println("Title Price publishdate rating pagecount");
		Publication publication = new Book(sc.next(), sc.nextInt(), LocalDate.parse(sc.next()), sc.nextInt(),
				sc.nextInt());	
	
	return  publication;
	}
	public static Publication addNewTape(HashMap<Integer,Publication>publications)
	{
		System.out.println("Enter the Tape Details ");
		System.out.println("Title Price publishdate rating Playtime");
		Publication publication = new Book(sc.next(), sc.nextInt(), LocalDate.parse(sc.next()), sc.nextInt(),
				sc.nextInt());	
		
		return  publication;
	}
	
	
}
