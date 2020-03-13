import java.util.ArrayList;
//import java.util.Comparator;

public class Invoice {
	
	private String invoiceNumber;
	private Account account;
	private double amount = 0.0;
	private Date orderDate;
	private ArrayList<Product> products;
	private ArrayList<Invoice> invoices;
	private ArrayList<Account> accounts;
	
	public Invoice() {}
	
	public Invoice (Account acct, double amount, Date date, ArrayList<Product> products) {
		
		setInvoice();
		this.account   = acct;
		getAmountDue();
		this.orderDate = date;
		this.products  = products;
			
		}
	
	public Account getAccount() {
		
		return account;
		
	}
	
	public double getAmount() {
		
		return amount;
		
	}
	
	public Date getDate() {
		
		return orderDate;
		
	}
	
	public double getAmountDue() {
		double amount = 0;
		for(int i = 0; i < products.size(); i++) {
			amount = amount +products.get(i).getprice();
		}
		this.amount = amount;

		return amount;
		
	}
	
	public void setDate(Date date) {
		
		this.orderDate = date;
		
	}
	
	private void setInvoice() {
		// sets the ID account as the invoice
		String id = account.getID();
		this.invoiceNumber = id;
	}
	
	public String toString() {
		// calling toString for each product 
		String listProducts = "";
		for(int i = 0; i < products.size(); i++) {
			listProducts = listProducts + products.get(i).toString();
		}
		return "Invoice: " +invoiceNumber+ "\n" +
				"Name: "+account.getCustomer().getName()+
				"Date Order: "+orderDate.toString()+ "\n" +
				"Amount: $"+ amount + "\n" + listProducts;
		
	}
	
	public int compareTo(Invoice otherInvoice) {
		getAmountDue();
        if(this.amount < otherInvoice.amount)      return -1;
        if(this.amount > otherInvoice.amount)      return  1;
        						
        /* they are equal */				return  0;
		
	}
	
	public void printInvoices() {
		// creates, sorts, and prints 1000 invoice
		// creating array list of invoice
		this.accounts = Account.accounts();
		System.out.println(accounts);
		//ArrayList<Invoice> sortedInvoices = new ArrayList<Invoice>();
		for(int e = 0; e < 1000; e++) {
			setInvoice();
			getAmountDue();
			Account theAccount = accounts.get((int) Math.random() *1000);
			ArrayList <Product> listProds = new ArrayList <Product>();
			for(int x = 1; x < (int) (Math.random()*20)+1 ;x++) {
				listProds.add(products.get(x));
			}//theAccount, amount,theAccount.getDate(), listProds
			Date date = theAccount.getDate();
			Invoice invoice = new Invoice( theAccount, amount, date, listProds);
			invoices.add(invoice);
			this.invoices.addAll(invoices);
		}
		// sorting the invoice array list
		//sortedInvoices = invoices.sort(invoice , amount);
		
		// printing invoice
		for(int y=0; y<1000; y++) {
			System.out.println(invoices.get(y).toString());
		}
	}
	
	public static void main(String[] args) {
		Invoice inv = new Invoice();
		inv.printInvoices();
	}

}
