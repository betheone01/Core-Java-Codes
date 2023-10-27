package Tester;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import static utils.ExceptionValidationRules.addNewBook;
import static utils.ExceptionValidationRules.addNewTape;

import core.Book;
import core.Publication;
import core.Tape;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner(System.in))
		{
			HashMap<Integer,Publication>publications=new HashMap<>();
			Publication a=new Book("Randi The Phodi", 5000,LocalDate.parse("2020-01-01"), 10,500);
			Publication b=new Book("Chinal Ke Lavde", 1000,LocalDate.parse("2019-01-01"), 9,200);
			Publication c=new Tape("Bewafa ke chuze", 2000,LocalDate.parse("2054-01-01"), 3,60);
			Publication d=new Book("danny ki gand ", 3000,LocalDate.parse("2023-10-25"), 5,100);
			Publication e=new Tape("Buri gat ke", 6000,LocalDate.parse("2023-10-24"), 0,20);
			Publication f=new Book(" Raaj the secrets ", 9000,LocalDate.parse("2023-10-25"), 10,20);
			
			
			publications.put(a.getId(),a);
			publications.put(b.getId(),b);
			publications.put(c.getId(),c);
			publications.put(d.getId(),d);
			publications.put(e.getId(),e);
			publications.put(f.getId(),f);
			boolean exit=false;
			while(!exit)
			{
				System.out.println("1.Publish new Book");
				System.out.println("2.Publish new Tape");
				System.out.println("3.List all book publications ordered by publish date in  descending order ");
				System.out.println("4.List all top 5 publications of current year based on rating ");
				System.out.println("5.Remove all publications which are 5 year old ");
				try 
				{
					System.out.println("Enter the choice ");
					switch(sc.nextInt())
					{
					case 1:///publish new book
//										//String title, int price, LocalDate publishDate, int rating
					Publication p=addNewBook(publications);
					//validAllInputsForBook(sc.next(),sc.nextInt(),sc.next(),sc.nextInt());
//						//addNewBook(publications);
						
						break;
					case 2:
						
						p=addNewTape(publications);
						
						publications.put(p.getId(), p);
						break;
					case 3:
						System.out.println("List all book publications ordered by publish date in  descending order");
						 publications.values().stream()
						 .filter(w->w instanceof Book)
						 .sorted((p1,p2)->p1.getPublishDate()
						 .compareTo(p2.getPublishDate() ))
						 .forEach(p1->System.out.println(p1));
					break;
					case 4:
						publications.values().stream()
						.filter(p1->p1.getPublishDate().getYear()==LocalDate.now().getYear())
						.sorted((p1,p2)->((Integer)p1.getRating()).compareTo(p2.getRating() )).limit(5)
						.forEach(q->System.out.println(q));
						break;
					case 5:
						publications.values().removeIf(s->s.getPublishDate().isBefore(LocalDate.now().minusYears(5)));
						
						break;
					case 7://List all tape publications ordered by publish date in  descending order
//						publications.values().stream()
//						.filter(n->n instanceof Tape)
//						.sorted((p1,p2)->p1.getPublishDate().compareTo(p2.getPublishDate()))
//						.forEach(p1->System.out.println(p1));
						
						publications.values().stream()
						.filter(n->n instanceof Tape)
						.sorted(Comparator.comparing(Publication::getPublishDate)).forEach(y->System.out.println(y));
						break;
					case 8:
						//List all book publications ordered by publish date in  descending order
						
						publications.values().forEach(q->System.out.println(q));
						break;
						
					}
					
				}
				catch(Exception e1)
				{
					System.out.println(e1.getMessage());
					sc.nextLine();
				}
			}
		}
				
		
	}

}
