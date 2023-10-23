package com.app.core;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Color.BLACK);
		Color.BLACK.setAdditional(1000);
		
		System.out.println(Color.BLACK.getAdditionalCost());
		Color.BLACK.setAdditional(100000);
		System.out.println(Color.BLACK.toString());
		
	}

}
