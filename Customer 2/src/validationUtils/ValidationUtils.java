package validationUtils;

import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.List;

import core.Customer;
import core.ServicePlan;
import customException.CustomerException;

public class ValidationUtils {

	public static void validateEmail(String email, List<Customer> custlist) throws CustomerException {
		if (custlist.contains(new Customer(email)))
			throw new CustomerException("Duplicate Email Found!!");

	}

	public static ServicePlan validatePlan(String plan) throws IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	public static void validatePlanCharge(ServicePlan plan, double amt) throws CustomerException {
		if (!(plan.getCharges() == amt))
			throw new CustomerException("Amount not matching with Plan");
	}

	public static Customer signUp(String firstname, String lastname, String email, String password,
			double registrationamt, String dob, String plan, List<Customer> custlist) throws CustomerException {
		validateEmail(email, custlist);
		ServicePlan serviceplan = validatePlan(plan);
		validatePlanCharge(serviceplan, registrationamt);
		Customer customer = new Customer(firstname, lastname, email, password, registrationamt, LocalDate.parse(dob),
				serviceplan);
		return customer;

	}

	public static Customer signIn(int index, String pass, List<Customer> custlist) throws CustomerException {
		Customer c = custlist.get(index);
		if (c.getPassword().equals(pass)) {
			return c;
		}
		throw new CustomerException("Password Not Matched!");
	}

	public static void changePass(Customer c, String oldpass, String newpass) throws CustomerException {
		if (c.getPassword().equals(oldpass))
			c.setPassword(newpass);
		else
			throw new CustomerException("Old password doesnt matched!!!");
	}
}
