import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	
	private String name;
	private String description;
	private double price;
	private String sku;
	
	public Product() {};
	
	public Product(String name, String description, double price, String sku) {
		
		this.name 		 = name;
		this.description = description;
		this.price		 = valPrice(price);
		this.sku		 = valSku(sku);
		
	}
	
	public Product(String sku) {
		
		this.sku = valSku(sku);
		
	}
	
	private String valSku(String sku) {
		
		if(sku.substring(0, 3).equals("001") ||
		   sku.substring(0, 3).equals("002") ||
		   sku.substring(0, 3).equals("003") ||
		   sku.substring(0, 3).equals("004") ||
		   sku.substring(0, 3).equals("110")) {
			return sku;
		}
		else {
			return "Not valid";
		}
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public void setPice(double price) {
		
		this.price = price;
		
	}
	
	
	public double getprice() {
		
		return this.price;
		
	}
	
	private double valPrice(double price) {
		
		if(price >= 0) {
			return price;
		}
		else {
			return price * (-1);
		}
		
	}
	
	public boolean equals(Product otherProduct) {
		
		return  this.name   	   == otherProduct.name    &&
                this.description   == otherProduct.description  &&
                this.price   	   == otherProduct.price &&
                this.sku     	   == otherProduct.sku;
		
	}
	
	public String toString() {
		
		return sku + "\n" + "Product: " + name + ", " + description + 
        		"- $ " + price;
		
	}
	
	public ArrayList<Product> products(){
		
		// Creates and fills an array list of products
		ArrayList <Product> products = new ArrayList <Product>();
		try {
			Scanner input = new Scanner(new File("customers.txt"));
			String line = input.nextLine();
			while(input.hasNextLine()) {
				// it splits by tab space each line
				String [] splitedTab = line.split("\t");
				String name = splitedTab[0];
				String description = splitedTab[1];
				String priceString = splitedTab[2];
				String sku = splitedTab[3];
				double price = Double.parseDouble(priceString);
				Product product = new Product(name,description,price,sku);
				products.add(product);
				System.out.println(products);
				}
			input.close();
			}
			catch(Exception e) {
				System.out.println("File not found.");
			}
		return products;
	}

}// end class
