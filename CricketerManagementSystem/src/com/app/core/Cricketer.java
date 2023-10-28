package com.app.core;

public class Cricketer {
	//String name,int age,String email_id,String Phone,int rating
	private String  name,email,phone;
	private int age;
	private int rating;
	
	public Cricketer(String name, String email, String phone, int age, int rating) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.rating = rating;
	}
	
public Cricketer(String email)
{
	this.email=email;
}
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", email=" + email + ", phone=" + phone + ", age=" + age + ", rating="
				+ rating + "]";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
