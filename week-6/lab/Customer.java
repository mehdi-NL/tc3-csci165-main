import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	
	public Customer() {}
	
	public Customer (String firstName, String lastName, String email,
			Address address) {
		
		this.firstName = firstName;
		this.lastName  = lastName;
		this.email	   = valEmail(email);
		this.address   = address;
		
	}
	
	public Customer (String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName  = lastName;
		
	}
	
	public void setName (String first, String last) {
		
		this.firstName = first;
		this.lastName  = last;
		
	}
	
	public String valEmail(String email) {
		
		// checks that there is only one "@"
		if(email.split("@").length > 2) {return "None on file.";}
		else {
			String [] splited = email.split(".");
			int indx = splited [0].indexOf("@");
			// checks that there are no "." before "@"
			if(indx == -1) {return "None on file.";}
			else {
				// checks the size of the domain
				int sizeDomain = splited[splited.length -1].length();
				if( sizeDomain == 2 || sizeDomain == 3) {
					return email;
				}
				else {return "None on file.";}
			}
			
		}
		
	}
	
	public void setEmail (String email) {
		
		this.email = email;
		
	}
	
	public String getName() {
		
		return this.firstName + "," + this.lastName;
		
	}
	
	public String getEmail() {
		
		return this.email;
		
	}
	
	public boolean equals (Customer otherCustomer) {
		
		return  this.firstName == otherCustomer.firstName    &&
                this.lastName  == otherCustomer.lastName  &&
                this.email     == otherCustomer.email &&
                this.address   == otherCustomer.address;
		
	}
	
	public String toString() {
		
		return "FirstName: " + firstName + ", lastName: " + lastName + 
        		", email: " + email + ", and address: " + address.toString() + ".";
		
	}
	
	public static ArrayList<Customer> customers(){
		// Creates and fills an array list of customers
		ArrayList <Customer> customers = new ArrayList <Customer>();
		try {
			Scanner input = new Scanner(new File("customers.txt"));
			String line = input.nextLine();
			while(input.hasNextLine()) {
				// it splits by tab space each line
				String [] splitedTab = line.split("\t");
				String first = splitedTab[0];
				String last = splitedTab[1];
				String email = splitedTab[2];
				String street = splitedTab[3] + " " + splitedTab[4] + " " + splitedTab[5];
				String zip = splitedTab[splitedTab.length - 1];
				Address address = new Address(street, zip);
				Customer customer = new Customer(first,last,email,address);
				customers.add(customer);
				System.out.println(customers);
				}
			input.close();
			}
			catch(Exception e) {
				System.out.println("File not found.");
			}
		return customers;
	}

}
