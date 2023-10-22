package core;

import java.util.List;

public class CustomerUtils {

	public static int findByEmail(String email,List<Customer> custlist)
	{
		Customer c=new Customer(email);
		return custlist.indexOf(c);

	}
}
