package core;

import java.time.LocalDate;

public class Publication
{

	private int id;
	private String title;
	private int price;
	private LocalDate publishDate;
	private int rating;
	
	private static int idGenerator=0;
	
	public Publication( String title, int price, LocalDate publishDate, int rating)
	{
		super();
		this.id = ++idGenerator;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
		this.rating = rating;
	}
//	pk
	
	public Publication(int id)
	{
		this.id=id;
	}
	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate
				+ ", rating=" + rating + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
