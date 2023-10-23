package Tester;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Vehicle;

import utils.VehicleValidationRules;

import static utils.VehicleValidationRules.ValidateAllInputs;
import static utils.ShowroomUtils.findByChasisNo;

public class ShowroomManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner(System.in))
		{
			List<Vehicle> vehicleList = new ArrayList<>();//
			boolean exit=false;
			while(!exit)
			{
				System.out.println("Options : 1 . Add a vehicle 2.Display All \n" + "3. Get Specific Vehicle details \n"
						+ "4. Apply discount 0.Exit");
				System.out.println("Enter the choice ");
				try
				{
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Enter vehicle details :  chasisNo,  vehicleClr,  basePrice,  manufactureDate, company");
						Vehicle validatedVehicle=ValidateAllInputs(sc.next(), sc.next(), sc.nextInt(), sc.next(),
								sc.next(), vehicleList);
						vehicleList.add(validatedVehicle);
						System.out.println("added vehicle to the showroom");
						break;
					case 2: // display all
						System.out.println("Showroom details");
						// via for-each
						for (Vehicle v : vehicleList)
							System.out.println(v);// toString : Vehicle (with clr based net price)
						break;
					case 3:
						System.out.println("Enter ch no , to get vehicle details");
						// Tester invokes : Showroom Utils method
						Vehicle vehicle = findByChasisNo(sc.next(), vehicleList);
						// => found
						System.out.println(vehicle);
						break;
					case 4:
						System.out.println("Enter ch no n discount");
						vehicle = findByChasisNo(sc.next(), vehicleList);
						//=> found , set price
						vehicle.setBasePrice(vehicle.getBasePrice()-sc.nextInt());
						System.out.println("discount applied....");						
						break;

					case 0: // shut down (destroy phase)
						exit = true;
						break;
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.out.println("Pls retry....");
					// to read off all pending i/ps
					sc.nextLine();
				}
			}
		}
		System.out.println("Main over ");
	}

}
