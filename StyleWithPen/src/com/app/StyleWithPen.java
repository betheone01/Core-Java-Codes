package com.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.Brand;
import enums.Material;

import static utils.penValidationRules.*;

public class StyleWithPen {
	public static void main(String[] args)
	{
	
	//Data structure to store the pens in the store
		ArrayList<Pen> pens = new ArrayList<>() {
				{add(new Pen(Brand.CELLO,"red","blue",Material.PLASTIC,100,LocalDate.parse("2023-01-01"),20));
				add(new Pen(Brand.PARKER,"Blue","black",Material.METAL,50,LocalDate.parse("2023-07-22"),20));
				}
			};

		try(Scanner sc = new Scanner(System.in)){

			boolean exit = false; // exit flag
		do
		{
			try {
				int choice;
				
			System.out.println("\n1.Add new Pen\n2.Update stock of a pen\n"
					+ "3.Set discount of 20% for all the pens which are not at all sold in last 3 months\n4."
					+ "Remove pens which are never sold once listed in 9 months\n"
					+ "5.Display all pens\n0.EXIT");
			
				switch (choice = sc.nextInt()){
				case 1:
					System.out.println("Enter:\nBrand, Color, inkColor, Material, Stock(qnty), stockListingDate, price");
					Pen p = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),sc.next(), sc.nextInt());
					pens.add(p);
					System.out.println("Pen added successfully!");
					break;
					
				case 2:
					// update pen stock for brand, qnty list
					updatePenStock(sc.next(),sc.nextInt(),pens);
					System.out.println("Stock updated successfully!");
					break;
				case 3:
					// set discount for pen which are not sold in last 3 months
					setDiscount(pens);
					break;
				case 4:
					removeOldPens(pens);
					System.out.println("All pens older than 9 months are removed");
					break;
				case 5:
					for(Pen p1: pens)
						System.out.println(p1);
					break;
				}
			
			}catch(Exception e){
			e.printStackTrace();
			sc.nextLine();
			}
			
		}while(!exit);
		}
	}
}
