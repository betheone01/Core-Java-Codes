package core;

import java.time.LocalDate;

public class Customer {

	private static int id;
	private int customerid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double registrationamt;
	private LocalDate dob;
	private ServicePlan plan;
	
	static {
		id=10000;
		
	}

	public Customer(String firstname, String lastname, String email, String password, double registrationamt,
			LocalDate dob, ServicePlan plan) {
		super();
		customerid=++id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.registrationamt = registrationamt;
		this.dob = dob;
		this.plan = plan;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", registrationamt=" + registrationamt + ", dob=" + dob + ", plan="
				+ plan + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer)
		{
			Customer cobj=(Customer)obj;
			
		if(this.email.equals(cobj.email))
		{
			return true;
		}
		}		
		return false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
