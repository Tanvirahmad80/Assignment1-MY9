public class Artist {

	// Attributes..
	private String name;
	private Artist next;
	
	// Constructor..
	public Artist(String name) {
		
		this.name = name;
		this.next = null;
	
	}
	
	public Artist(String name, Artist next) {
	
		this.name = name;
		this.next = next;
	
	}

	// Getter and Setters..
	
	public String getName() {

		return name;
	
	}

	public void setName(String name) {
	
		this.name = name;
	
	}

	public Artist getNext() {
	
		return next;
	
	}

	public void setNext(Artist next) {
	
		this.next = next;
	
	}
	
}
