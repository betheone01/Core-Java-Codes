package tester;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Customer;
import customException.CustomerException;
import static core.CustomerUtils.*;

import static validationUtils.ValidationUtils.*;

public class CustomerTester {

	public static void main(String[] args) {
		
		int index=-1;
		boolean done=false;
		
		List<Customer> custlist=new ArrayList<Customer>();
		
		try(Scanner sc=  new Scanner(System.in))
		{
			while(!done)
			{
				System.out.println("*************Menu*************");
				System.out.println("1.SignUp\n 2.SignIn\n3.change Password\n 4.unsubscribr"
						+ "\n5.Diplay\n 0:exit");
				System.out.println("Choose");
				
				try {
					switch(sc.nextInt())
					{
					case 1: System.out.println("Signin");
					System.out.println("Enter firstname, lastname,  email,  password,  registrationamt, dob(yyyy-MM-dd), String plan");
					Customer c=signUp(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),custlist);
					custlist.add(c);
					System.out.println("Customer Registration Successful...");	
					break;
						
					case 2:
						System.out.println("SignIn");
						System.out.println("Enter Email");
						 index = findByEmail(sc.next(),custlist);
						if(index==-1)
							throw new CustomerException("Email Doesnt exist!");
						System.out.println("enter Password");
						Customer signCust=signIn(index, sc.next(), custlist);
						System.out.println("Sign IN Successfull for "+ signCust);
						
						
						break;
						
					case 3://change password
						System.out.println("Enter Email");
						index=findByEmail(sc.next(), custlist);
						if(index==-1)
							throw new CustomerException("Email Doesnt exist!");
						changePass(custlist.get(index),sc.next(),sc.next());
						System.out.println("Password Changed Successfully :) ");
						break;
						
					case 4:
						System.out.println("Enter Email id for unsbscribing customer");
						index=findByEmail(sc.next(), custlist);
						if(index==-1)
							throw new CustomerException("Email Doesnt exist!");
						System.out.println("Customer unsbscribed : "+ custlist.remove(index));
						break;
						
					case 5:
						System.out.println("Customer Details ");
						for(Customer customer:custlist)
						{
							System.out.println(customer);
						}
						break;
					
					case 0: done = true;
					break;
					
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.out.println("Try Again");
					sc.nextLine();
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
