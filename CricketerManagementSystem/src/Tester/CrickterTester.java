package Tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Cricketer;
/*   dravid dravid@gmail 9999999 22 5
   mayur mayur@gmail 0000000 22  5
   danny danny@gmail 1111111 24 4
  dhani  dhani@gmail 22222222 23 2
  smit smit@gmail 3333333 22 1
  */
public class CrickterTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner(System.in))
		{
			Map<String ,Cricketer>cricketers=new HashMap<>();
			cricketers.put("mayurpatil7208", new Cricketer("Mayur", "mayurpatil7208", "94231455", 10, 5));
			cricketers.put("Raajpatil7208", new Cricketer("Raj", "Raajpatil7208", "90000000", 20, 10));
			cricketers.put("Dannypatil", new Cricketer("Danny", "Dannypatil", "100000000", 25, 0));
			boolean exit=false;
			while(!exit)
			{
				System.out.println("\n"
						+ "1.Accept minimum 5 Cricketers in the collection.\n"
						+ "\n"
						+ "2.Modify Cricketer's rating\n"
						+ "\n"
						+ "3.Search Cricketer by name\n"
						+ "\n"
						+ "4. Display all Cricketers added in collection.\n"
						+ "\n"
						+ "5.Display All Cricketers in sorted form by rating.\n"
						+ "");
				try {
					switch(sc.nextInt())
					{
					case 1:
					
						System.out.println(" name,  email,  phone,  age,  rating");
						//String name, String email, String phone, int age, int rating
						
						for(int i=0;i<5;i++)
						{
							Cricketer c=new Cricketer(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextInt());
							cricketers.put(c.getEmail(), c);
						}
						System.out.println("successfully added ");
						
						break;
						
					case 2:
						System.out.println("Please enter the email id of cricketer ");
						String email=sc.next();
						System.out.println("enter the rating you want to update ");
						int rating =sc.nextInt();
						Cricketer a=new Cricketer(email);
						if(cricketers.containsKey(email))
						{
							cricketers.get(email).setRating(rating);
						}
						else {
							System.out.println("Players with the email id "+email+"not found ");
						}
						System.out.println("Successfully updated rating ");
						break;
						
					case 3://Search Cricketer by name
						System.out.println("Enter name of cricketer");
						String name=sc.next();
						boolean found=false;
						//Cricketer b=new Cricketer(name);
						
						cricketers.values().stream().filter(q->q.getName().equals(name)).forEach(p->System.out.println(p));
//						for(Cricketer c:cricketers.values())
//						{
//							
//							if(c.getName().equals(name))
//							{
//									System.out.println(c);
//									found=true;
//							}
//							
//						}
//						if(!found)
//						{
//							System.out.println("failed");
//						}
						break;
					
						
						
							
						
						
						
						
						
					case 4:
						for(Cricketer c:cricketers.values())
						{
							System.out.println(c);
						}
						break;
					case 5:
						
//						accounts.values().stream()
//						.sorted((r1,r2)-> ( (Integer) r1.getAccNo()).compareTo(r2.getAccNo() ))
//						.forEach(s1->System.out.println(s1));
//						
						cricketers.values().stream()
						.sorted((p1,p2)-> ( (Integer)p1.getRating() ).compareTo(p2.getRating()) ).forEach(p->System.out.println(p));;
						
						break;
						
						
						
						
						
						
						
						
					}
					
						
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					sc.nextLine();				
				}
			}
		}
		
	}

}
