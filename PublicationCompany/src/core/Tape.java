package core;

import java.time.LocalDate;

public class Tape extends Publication {

	public Tape(int id) {
		super(id);
			}

	
	private int playtime;
	
	public Tape(String title, int price, LocalDate publishDate, int rating, int playtime) {
		super(title, price, publishDate, rating);
		this.playtime = playtime;
	}

	@Override
	public String toString() {
		return "Tape [PlayTime=" + playtime + ", [ id no "+super.getId() +" ] Title" + getTitle() + ", Price=" + getPrice()
				+ ", PublishDate=" + getPublishDate() + ", Rating=" + getRating()   + "]";
	}
	
	
}
