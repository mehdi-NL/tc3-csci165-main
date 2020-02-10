// Mehdi, Nya Louhaichy
// 2/9/2020

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class problem2{

	public static void main(String[] args) {

		// This array will collect all the sequences in the file
	  try{
      // Creating scanner instance to connect the File object.
	    Scanner numberScanner = new Scanner(new File("numbers.txt"));
      // Creating file writer
      FileWriter encodedNumber = new FileWriter("encodedNumbers.txt");
      // This while will read the numbers from numbers.txt
      while(numberScanner.hasNextLine()){
        String numberLine = numberScanner.nextLine();
        // Creating symbol code, numeral, and encoded Strings
   		 String symbolCode = "*BEA@FK%RM";
   		 String numeral = "0123456789";
   		 String encoded = "";
   		 // Loop to comper the input and encod it into a new string
   		 for(int i = 0; i < numberLine.length(); i++){
   			 if(numeral.charAt(0) == numberLine.charAt(i)){
   				 encoded = encoded + symbolCode.charAt(0);
   			 }
   			 if(numeral.charAt(1) == numberLine.charAt(i)){
    				encoded = encoded + symbolCode.charAt(1);
    			 }
   			 if(numeral.charAt(2) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(2);
   			 }
   			 if(numeral.charAt(3) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(3);
   			 }
   			 if(numeral.charAt(4) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(4);
   			 }
   			 if(numeral.charAt(5) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(5);
   		 	 }
   		 	 if(numeral.charAt(6) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(6);
   			 }
   			 if(numeral.charAt(7) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(7);
   			 }
   			 if(numeral.charAt(8) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(8);
   			 }
   			 if(numeral.charAt(9) == numberLine.charAt(i)){
   				encoded = encoded + symbolCode.charAt(9);
   			 }
   		 }
       // Writting output into the file encodedNumbers.txt
       encodedNumber.write(encoded);
       encodedNumber.write("\n");

      }// End while Loop

      // Closing scanner
	    numberScanner.close();
      // Closing the writer
		  encodedNumber.close();
    }// End try

    catch(IOException e) {

    }// End catch

  }
}
