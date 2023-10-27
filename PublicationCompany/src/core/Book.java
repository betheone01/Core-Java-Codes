package core;

import java.time.LocalDate;

public class Book extends Publication 
{

	public Book(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	private int pageCount;
	
	public Book(String title, int price, LocalDate publishDate, int rating, int pageCount) 
	{
		super(title, price, publishDate, rating);
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book [pageCount=" + pageCount+ ", [ id no"+super.getId() + " ], Title" + getTitle() + ", Price=" + getPrice()
				+ ", PublishDate=" + getPublishDate() + ", Rating=" + getRating()    + "]";
	}
	
	

}
