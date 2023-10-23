package com.app.core;

public enum Color {

	WHITE(5000), BLACK(10000), BLUE(6500), SILVER(8000);
	
	private int additionalCost;
	private Color (int additionalCost)
	{    
		this.additionalCost=additionalCost;
	}
	
	public int getAdditionalCost()
	{
		return additionalCost;
	}
	public void setAdditional(int additionalCost)
	{
		this.additionalCost=additionalCost;
	}
	
	@Override
	public String toString()
	{
		return name()+" with additional cost "+additionalCost;
	}
	
}
