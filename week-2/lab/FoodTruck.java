// Mehdi, Nya Louhaichy
// 02/05/2020

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FoodTruck{
	
	public static void main(String[] args) {
		
		// This array will collect all the items in the files
		String [] menu_prices = new String [6];
		// In this array we will save the input quantities
        String [] quantities = new String [3];
        
		try{
			  
			 // Array counter
	         int counter = 0;

	          // Creating scanner instance to connect the File object.
	          Scanner menuScanner = new Scanner(new File("menu.txt"));
	          
	         
	          // Creating file writer
	          FileWriter ticket = new FileWriter("ticket.txt");
	          
	          // This while will read the menu.txt and save it into the menu_price array
	          while(menuScanner.hasNextLine()){
	            
	            String menuLine = menuScanner.nextLine();
	            menu_prices[counter] = menuLine;
	            counter++;

	          } // end while loop
	          
	          // Closing scanner
	          menuScanner.close();
	          // creating new scanner for price.txt
	          Scanner pricesScanner = new Scanner(new File("price.txt"));
	          // This while will collect all the prices into menu_price array
	          while(pricesScanner.hasNextLine()){
	        	
		            String pricesLine = pricesScanner.nextLine();
		            menu_prices [counter] = pricesLine;
		            counter++;

		          } // end while loop

	          // Closing scanner
	          pricesScanner.close();

		 // Greeting and input
		 System.out.println("Welcome to the CS food truck");
		 // Getting users name
         Scanner keyboardInput = new Scanner(System.in);
         System.out.print("Enter Your Name: ");
         String name = keyboardInput.nextLine();
         // Asking user for amount of each item in the menu
		 System.out.println("Enter the quantity of each item ");
		 System.out.println("======================");
		 System.out.print( menu_prices[0] + " - $" + menu_prices [3] + ": ");
		 quantities [0] = keyboardInput.nextLine();
		 System.out.print( menu_prices[1] + " - $" + menu_prices [4] + ": ");
		 quantities [1] = keyboardInput.nextLine();
		 System.out.print( menu_prices[2] + " - $" + menu_prices [5] + ": ");
		 quantities [2] = keyboardInput.nextLine();
		 
		 // Getting elements to build the invoice
		 String [] splitedName = name.split(" ");
		 String initials = splitedName[0].substring(0,2) + splitedName[1].substring(0,2);
		 String upperInitials = initials.toUpperCase();
		 
		 String initialName = splitedName[0].substring(0);
		 String initialLastName = splitedName[1].substring(0);
		 
		 // We will get the numeric value of the initials
		 int numName = initialName.charAt(0);
		 int numLastName = initialLastName.charAt(0);
		 
		 // Sum of the numeric values
		 int sum = numName + numLastName;
		 // Length of the full name
		 int lengthName = name.length();
		 int multi = sum * lengthName;
		 // Getting the actual date
		 Date thisDate = new Date();
		 // Formating the date
		 SimpleDateFormat dateForm = new SimpleDateFormat("M/dd/Y");
		 // Formating the time
		 SimpleDateFormat timeForm = new SimpleDateFormat("HH:mm:ss");
		 // Formating date-time for the invoice
		 SimpleDateFormat invoiceForm = new SimpleDateFormat("MddYHHmm");
		 // Constructing the invoice number
		 String invoiceNum = initials + multi + invoiceForm.format(thisDate);
		 
		 // Output:
		 System.out.println("Invoice Number:   " + invoiceNum);
		 System.out.println("Date:             " + dateForm.format(thisDate));
		 System.out.println("Time:             " + timeForm.format(thisDate));
		 System.out.println("                  ");
		 System.out.println("Item              Quantity    Price Total");
		 System.out.println("===================================");
		 double amount0 = Math.round((Integer.parseInt(quantities[0]) * Double.parseDouble(menu_prices[3]))*100)/100.0;
		 System.out.println(menu_prices[0] + "   " + quantities[0] + "      $" + menu_prices[3] + "  $" + amount0);
		 double amount1 = Math.round((Integer.parseInt(quantities[1]) * Double.parseDouble(menu_prices[4]))*100)/100.0;
		 System.out.println(menu_prices[1] + "           " + quantities[1] + "      $" + menu_prices[4] + "  $" + amount1);
		 double amount2 = Math.round((Integer.parseInt(quantities[2]) * Double.parseDouble(menu_prices[5]))*100)/100.0;
		 System.out.println(menu_prices[2] + "       " + quantities[2] + "      $" + menu_prices[5] + "  $" + amount2);
		 System.out.println("===================================");
		 double subtotal = Math.round((amount0 + amount1 + amount2)*100)/100.0;
		 System.out.println("Subtotal                       $" + subtotal);
		 double taxRate = 6.25/100;
		 double tax = Math.round((subtotal * taxRate) * 100)/100.0;
		 System.out.println("6.25% sales tax                $" + tax);
		 double total = Math.round((subtotal + tax) * 100)/100.0;
		 System.out.println("Total                          $" + total);
		 
		 
		 // Writting output into the file ticket.txt
		 ticket.write("Invoice Number:   " + invoiceNum+"\n");
		 ticket.write("Date:             " + dateForm.format(thisDate)+"\n");
		 ticket.write("Time:             " + timeForm.format(thisDate)+"\n");
		 ticket.write("                  "+"\n");
		 ticket.write("Item              Quantity    Price Total"+"\n");
		 ticket.write("==================================="+"\n");
		 ticket.write(menu_prices[0] + "   " + quantities[0] + "      $" + menu_prices[3] + "  $" + amount0+"\n");
		 ticket.write(menu_prices[1] + "           " + quantities[1] + "      $" + menu_prices[4] + "  $" + amount1+"\n");
		 ticket.write(menu_prices[2] + "       " + quantities[2] + "      $" + menu_prices[5] + "  $" + amount2+"\n");
		 ticket.write("==================================="+"\n");
		 ticket.write("Subtotal                       $" + subtotal+"\n");
		 ticket.write("6.25% sales tax                $" + tax+"\n");
		 ticket.write("Total                          $" + total+"\n");
		 
		 // Closing the writer
		 ticket.close();

		 
		} // end try

		catch(IOException e) {

		} // end catch
			 
		 
	}
}