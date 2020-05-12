public class TopStreamingArtists {

	// Attributes..
	private Artist first;
	
	public TopStreamingArtists() {
		
	     first = null;
	  
	}
	
	public boolean isEmpty(){
	
		return (first == null);
	    
	}
	
	// add artist.
	public void addArtist(Artist artist) {
		
		if (first == null) {
			first = artist;
		} else {
			
			Artist current = first;
			if(current.getName().compareTo(artist.getName()) > 0) {
				artist.setNext(first);
				first = artist;
				return;
			}
			Artist previous = first;
			current = first.getNext();
			while(current != null) {
				
				if(current.getName().compareTo(artist.getName()) > 0) {
					artist.setNext(current);
					previous.setNext(artist);
					return;
				}
				previous = current;
				current = current.getNext();
				
			}
			previous.setNext(artist);
			
		}
		
	}
	
	// Displaying list.
	public void displayList() {
		
		Artist current = first;
		while(current != null) {
			System.out.println(current.getName());
			current = current.getNext();
		}
		
	}

}
