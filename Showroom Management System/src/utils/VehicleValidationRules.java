package utils;
import com.app.core.*;

import java.time.LocalDate;
import java.util.*;
import custom_exceptions.VehicleHandlingException;
import java.time.format.*;
public class VehicleValidationRules 
{

	public static void  checkForDups(String newChNo,List<Vehicle>vehicles)throws VehicleHandlingException
	{
		Vehicle newVehicle = new Vehicle(newChNo);
		if(vehicles.contains(newVehicle))
		{
			throw new VehicleHandlingException("Vehicle can't be added : dup ch no !!!!!!");
		}
		
		
	}
	public static Color colorValidation(String color)throws IllegalArgumentException
	{
		return Color.valueOf(color.toUpperCase());
	}
	
	public static LocalDate parseAndValidateDate(String Date)throws DateTimeParseException,VehicleHandlingException
	
	{
		LocalDate manuDate=LocalDate.parse(Date);
		LocalDate checkDate=LocalDate.of(2020, 01, 01);
		if(manuDate.isBefore(checkDate))
		{
			throw new VehicleHandlingException("Invalid Manufacture Date!!!!!");
		}
		return manuDate;
	}
	
	public static Vehicle ValidateAllInputs(String chasisNo,String VehicleClr,double baseprice,String manufactureDate,
			String company,List<Vehicle>showroom)throws VehicleHandlingException,IllegalArgumentException, DateTimeParseException
	{
		checkForDups(chasisNo,showroom);
		Color color=colorValidation(VehicleClr);
		LocalDate date=parseAndValidateDate(manufactureDate);
		return new Vehicle(chasisNo, color, baseprice, date, company);
		
		
	}
}
