package Tester;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import static utils.ExceptionRules.validAllinputs;
import static utils.ExceptionRules.upadateItem;

import Core.Grocery;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			HashMap<String, Grocery> items = new HashMap<>();
			items.put("Rice", new Grocery("Rice", 200, 0, LocalDateTime.parse("2020-01-01T10:15:30")));
			items.put("Wheat", new Grocery("Wheat", 100, 20, LocalDateTime.parse("2023-10-25T11:15:30")));
			items.put("Besan", new Grocery("Besan", 500, 30, LocalDateTime.parse("2021-01-01T10:15:30")));

			boolean flag = false;
			while (!flag) {
				try {
					System.out.println("0. Exit ");
					System.out.println("1.Add a new grocery item in list ");
					System.out.println("2.update quantity of grocery item to stock ");
					System.out.println("3.Dispaly list of grocery item with name,prices,quantites");
					System.out.println("4.Remove all empty stock itemss");
					System.out.println("5.Dispaly all products for which stock updated in last 3 days ");
					System.out.println("Enter the choice ");
					switch (sc.nextInt()) {
					case 1:
						// String name, int price, int stock, LocalDateTime dateTime
						System.out.println(" name of item ,  price,  stock, stock update  dateTime\n" + "");
						Grocery g = validAllinputs(sc.next(), sc.nextInt(), sc.nextInt(), sc.next(), items);
						items.put(g.getName(), g);

						break;
					case 2:
						System.out.println("Enter grocery item and quantity");
						upadateItem(sc.next(), sc.nextInt(), items);
						break;
					case 3:
						for (Grocery k : items.values()) {
							System.out.println(k);
						}
						break;
					case 4:
						for (Grocery l : items.values()) {
							if (l.getStock() == 0) {
								items.remove(l.getName());
							}
						}

						break;
					case 5:
						for (Grocery l : items.values()) {
							if (l.getDateTime().isAfter(LocalDateTime.now().minusDays(3))) {
								System.out.println(l);
							}

						}
						break;
					case 0:

						flag = true;
						System.out.println(" BYE ");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}

}
