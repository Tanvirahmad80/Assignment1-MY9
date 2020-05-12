//HASSAAN ASIF & TANVIR AHMAD
// CISC 3130

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApp {

	// Attributes..
	private final static String FILENAME = "data/usdataweek4.csv";
	
	// Main method.
	public static void main(String[] args) {

		// Attributes..
		int rows = 200;
		int cols = 4;
		String[][] myList = new String[rows][cols];
		int[] count = new int[rows];
		int index = 0;
		
		// Reading the file.
		try {
		
			Scanner scan = new Scanner(new File(FILENAME));
			scan.nextLine();
			scan.nextLine();
			// reading.
			while(scan.hasNextLine()) {
				
				String[] tokens = scan.nextLine().split(",");
				String artist = tokens[2];
				artist = artist.replaceAll("\"", "").trim();
				artist = artist.substring(0, 1).toUpperCase()+artist.substring(1);
				boolean found = false;
				for(int i = 0; i < index; i++) {
					if(artist.equals(myList[i][1])) {
						count[i]++;
						found = true;
						break;
					}
				}
				if(!found) {
					myList[index][0] = tokens[1];
					myList[index][1] = artist;
					myList[index][2] = tokens[3];
					myList[index][3] = tokens[4];
					index++;
				}
				
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// finding top streamed.  
		String topArtist = "";
		int topCount = -1;
		for(int i = 0; i < index; i++) {
			if(count[i] > topCount) {
				topArtist = myList[i][1];
				topCount = count[i];
			}
		}
		System.out.println("*** Top Streamed Person ***\n"
				+ "Artist: "+topArtist+"\n"
				+ "Count: "+topCount+"\n\n"
				+ "*** Music Artist in Alphabetical Order ***");
		
		
		// Reading complete.
		TopStreamingArtists artists = new TopStreamingArtists();
		// adding..
		for(int i = 0; i < index; i++) {
			
			artists.addArtist(new Artist(myList[i][1]));
			
		}
		artists.displayList();
		
	}

}