import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {
	
	private String accountID;
	private Customer customer;
	private double balance;
	private double creditLimit;
	private Date dateCreated;
	private double discountLevel;
	
	public Account() {}
	
	public Account (Customer customer) {
		
		createID();
		this.customer      = customer;
		ranBalance();
		setCreditLimit();
		setDateCreated();
		setDiscountLevel();
		
	}
	
	public Account (String id, Customer customer, double balance, double creditLimit, 
			Date dateCreated, double discountLevel) {
		
		this.accountID     = id;
		this.customer      = customer;
		this.balance       = valAmount(balance);
		this.creditLimit   = valCredit(creditLimit);
		this.dateCreated   = dateCreated;
		this.discountLevel = valAmount(discountLevel);
		
	}
	
	public Customer getCustomer() {
		
		return this.customer;
		
	}
	
	public double getBalance() {
		
		return this.balance;
		
	}
	
	public double valAmount(double amount) {
		
		// Maintains the amount positive
		if(amount < 0) { return amount * (-1); }
		else { return amount; }
		
	}
	
	public double valCredit(double credit) {
		
		// checks that credit is not bigger than two times the balance
		if(credit > (balance*2)) {return this.creditLimit = balance*2;}
		else {return credit;}
		
	}
	
	public double getCreditLimit() {
		
		return valAmount(this.creditLimit);
		
	}
	
	public void setBalance(double b) {
		
		this.balance = valAmount(b);
		
	}
	
	public void setCreditLimit(double cl) {
		
		this.creditLimit = valAmount(cl);
		
	}
	
	public void setDateCreated() {
		
		Date dateCreated = new Date();
		this.dateCreated = dateCreated.ranDate();
	}
	
	public Date getDate() {
		return dateCreated;
	}
	
	public double updateDiscount() {
		
		LocalDateTime now = LocalDateTime.now();
		int diff = now.getYear() - dateCreated.getYear();
		discountLevel = discountLevel + (0.2 * diff);
		return discountLevel;
		
	}
	
	public String toString() {
		
		return "ID: " + accountID + ", customer: " + customer.toString() + 
        		", balance: " + balance + ", creditLimit: " + creditLimit +
        		", date created: " + dateCreated.toString() +
        		", and discount level: " + discountLevel + ".";
		
	}
	
	public boolean equals (Account otherAccount) {
		
		return  this.accountID     == otherAccount.accountID    &&
                this.customer      == otherAccount.customer  &&
                this.balance       == otherAccount.balance &&
                this.creditLimit   == otherAccount.creditLimit &&
                this.dateCreated   == otherAccount.dateCreated &&
                this.discountLevel == otherAccount.discountLevel;
		
	}
	
	public int compareTo (Account otherAccount) {
		
		return 1; // To Do
		
	}
	
	public void createID() {
		// creates an ID number  with a name and a date
		// formating the name
		String id       = ""; 
		String name     = customer.getName();
		String noVowels = name.replaceAll("[aeiouAEIOU,]","");
		String noVowelsUpper = noVowels.toUpperCase();
		// Getting Ascii values of each char
		int sum = 0;
		int length = noVowelsUpper.length();
		for(int i = 0; i < length; i++) {
			sum = sum + ((int) noVowelsUpper.charAt(i));
		} 
		int checkDigit = sum % length;
		// formatting the date
		String date       = dateCreated.toString();
		String noBarsDate = date.replaceAll("/","");
		id = noVowelsUpper + noBarsDate + checkDigit;
		this.accountID    = id;
		
	}
	
	public String getID() {
		return accountID;
	}
	
	private void ranBalance() {
		// creates a random balance
		int ranBalance   = (int) (Math.random() * 10000) + 100;
		this.balance = ranBalance;
	}
	
	private void setCreditLimit() {
		// sets credit limit as 10% of the balance
		this.creditLimit   = valCredit(balance*0.1);
	}
	
	private void setDiscountLevel() {
		// sets the discount level based on the date created
		int yearOpened = dateCreated.getYear();
		int actualYear = 2020;
		double discountLevel = 0.2 * (actualYear - yearOpened);
		this.discountLevel = valAmount(discountLevel);
		
	}
	
	public static ArrayList <Account> accounts(){
		// Creates and fills an array list of accounts
		ArrayList <Account> accounts = new ArrayList <Account>();
		ArrayList <Customer> customers = Customer.customers();
		for(int i = 0; i < 1000; i++){
			accounts.add(new Account(customers.get(i)));
		}
		
		return accounts;
	}
}
