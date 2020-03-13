import java.io.File;
import java.util.Scanner;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address() {};
	
	public Address(String street, String zip){
		
		this.street = street;
		setZip(zip);
		
	}
	
	public void setStreet(String street) {
		
		this.street = street;
		
	}
	
	public String getStreet() {
		
		return this.street;
		
	}
	
	public String getCity() {
		
		return this.city;
		
	}
	
	public String getState() {
		
		return this.state;
		
	}
	
	public void setZip( String zip) {
		if(zip.length() == 4 || zip.length() == 5) {
			this.zip = zip;
			setCityState(zip);
		}
		else {
			this.zip = "Not in file";
		}
	}
	
	public String getZip() {
		
		return this.zip;
		
	}
	
	private void setCityState(String zip) {
		
		String [] zipCodes = new String [42633];
		String [] cities = new String [42633];
		String [] states = new String [42633];
		try {
		Scanner input = new Scanner(new File("products.txt"));
		String line = input.nextLine();
		int i = 0;
		while(input.hasNextLine()) {
			// it splits by the quotes in order to get easy access to the state
			String [] splitedQuotes = line.split("\"");
			state = splitedQuotes[2];
			// it splits by the commas in order to get the zip and the city
			String [] splitedComas = line.split(",");
			zipCodes [i] = splitedComas [0];
			cities [i] = splitedComas[3];
			states [i] = state;
			i++;
		}
		input.close();
		// this for loop tries to find the zip code inside the array.
		for(int e = 0; e < zipCodes.length; e++) {
			if(zipCodes[e] == zip) {
				this.city = cities [e];
				this.state = states [e];
				break;
			}
			else { 
				this.city = "zip not in file";
				this.state = "zip not in file";
			}
		}
		
		}
		catch(Exception e){
			System.out.println("File not found.");
		}
	}
	
	public boolean equals(Address otherAddress) {
		
		return  this.street   == otherAddress.street    &&
                this.city    == otherAddress.city  &&
                this.state   == otherAddress.state &&
                this.zip     == otherAddress.zip;
		
	}
	
	public String toString(){
        return "Street: " + street + ", city: " + city + 
        		", state: " + state + ", and zip: " + zip + ".";
	}
}// end class
