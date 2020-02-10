// Mehdi, Nya Louhaichy
// 2/9/2020

// Imports

import java.util.Scanner;

// Problem 1:
// This program will encode a sequence of base 10 digits following the KenSpeak
// table.

public class kenSpeak{

	public static void main(String[] args) {

    // Greeting and input
		 System.out.println("Welcome to the KenSpeak");
		 // Getting users input
     Scanner keyboardInput = new Scanner(System.in);
     System.out.print("Enter a sequence of base 10 digits: ");
     String sequence = keyboardInput.nextLine();
		 // Creating symbol code, numeral, and encoded Strings
		 String symbolCode = "*BEA@FK%RM";
		 String numeral = "0123456789";
		 String encoded = "";
		 // Loop to comper the input and encod it into a new string
		 for(int i = 0; i < sequence.length(); i++){
			 if(numeral.charAt(0) == sequence.charAt(i)){
				 encoded = encoded + symbolCode.charAt(0);
			 }
			 if(numeral.charAt(1) == sequence.charAt(i)){
 				encoded = encoded + symbolCode.charAt(1);
 			 }
			 if(numeral.charAt(2) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(2);
			 }
			 if(numeral.charAt(3) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(3);
			 }
			 if(numeral.charAt(4) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(4);
			 }
			 if(numeral.charAt(5) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(5);
		 	 }
		 	 if(numeral.charAt(6) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(6);
			 }
			 if(numeral.charAt(7) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(7);
			 }
			 if(numeral.charAt(8) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(8);
			 }
			 if(numeral.charAt(9) == sequence.charAt(i)){
				encoded = encoded + symbolCode.charAt(9);
			 }
		 }
		 System.out.println(encoded);
  }
}
