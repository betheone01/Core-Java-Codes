package Core;

import java.time.LocalDateTime;

public class Grocery {

	private String Name;
	private int price;
	private int stock;
	private LocalDateTime dateTime;

	public Grocery(String name, int price, int stock, LocalDateTime dateTime) {
		super();
		Name = name;
		this.price = price;
		this.stock = stock;
		this.dateTime = dateTime;
	}

	// pk
	public Grocery(String name) {
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock += stock;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Grocery [Name=" + Name + ", price=" + price + ", stock=" + stock + ", dateTime=" + dateTime + "]";
	}

}
