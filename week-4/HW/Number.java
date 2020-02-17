// Mehdi, Nya Louhaichy
// 2/13/2020

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

class Number{
// Exercise 1:
	// method to read and group data in a 1D array
	// Throw exception replaces the try-catch
	
	   public static int [] array1D() throws IOException{
		
		   // Creating scanner and a file reader object to read the file
		   FileReader fr   = new FileReader("number_list.txt");
		   Scanner number = new Scanner(fr);
		   // amount of data
		   int count = 1000;
		
		   // create empty array
		   int [] array1D = new int [count];
		   // index variable
		   int i = 0;
		   // filling the array
		   while (i<1000) {
			   array1D[i] = number.nextInt();
			   i++;
		   }// End while loop
		   // closing scanner and file reader objects
		   number.close();
		   fr.close();
		   
		   return array1D;
		   
	   }
	  
	   // Throw exception replaces the try-catch
	   public static void fillArray(int[] array) throws IOException{
		   // Creating scanner and a file reader object to read the file
		   FileReader fr   = new FileReader("number_list.txt");
		   Scanner number = new Scanner(fr);
		   // counter variable
		   int count = 0;
		   // while loop to check amount of numbers in the file
		   while (number.hasNextInt()) {
			   count++;
		   }
		   // create empty array
		   int [] fillArray = new int [count];
		   // index variable
		   int i = 0;
		   // filling the array
		   while (number.hasNextInt()) {
			   fillArray[i] = number.nextInt();
		   }// End while loop
		   // closing scanner and file reader objects
		   number.close();
		   fr.close();
		   System.out.println(fillArray);
		 
	   }
	  
	   public static int findMax(int[] array) {
		   // sorting the array
		   Arrays.sort(array);
		   // selecting the biggest value
		   int max =  array[array.length-1];
		   // returning the maximum value
		   return max;
		   
	   }
	   
	   public static int findMin(int[] array) {
		   
		// sorting the array
		   Arrays.sort(array);
		   // selecting the smallest value
		   int min =  array[0];
		   // returning the minimum value
		   return min;
		   
	   }
	   
	   public static int[] percentChange(int[] array){
		   // new array to introduce the percent change
		   int [] percentChange = new int [array.length -1];
		   // for loop to iterate inside the first array
		   for (int i = 0; i < array.length -1; i++) {
			   // introducing each amount of change in the new array
			   percentChange [i] = array[i+1] - array[i];
		   }// End for loop
		   return percentChange;
	   }
	   
// Exercise 2:
	// method to read and group data in row major order
	// Throw exception replaces the try-catch	
	   public static int[][] rowOrder() throws IOException{
		   
		   // creating the matrix
		   int [][] rowOrder = new int [50][20];
		   // Creating scanner and a file reader object to read the file
		   FileReader fr   = new FileReader("number_list.txt");
		   Scanner number = new Scanner(fr);
		   // nested loop to fill the table with the numbers
		   for (int i = 0; i < rowOrder.length; i++) {
			   for (int j = 0; j < rowOrder[i].length; j++) {
				   // introducing the numbers into the table
				   rowOrder[i][j] = number.nextInt();
			   }// End inner for  
		   }// End outer for
		   
		   // closing scanner and file reader objects
		   number.close();
		   fr.close();
		   
	   return rowOrder;
	   
	   }
	   // Throw exception replaces the try-catch	
	   public static void fillArray(int[][] matrix) throws IOException{
		   
		   // creating the matrix
		   int [][] table = new int [50][20];
		   // Creating scanner and a file reader object to read the file
		   FileReader fr   = new FileReader("number_list.txt");
		   Scanner number = new Scanner(fr);
		   // nested loop to fill the table with the numbers
		   for (int i = 0; i < table.length; i++) {
			   for (int j = 0; j < table[i].length; j++) {
				   // introducing the numbers into the table
				   table[i][j] = number.nextInt();
			   }// End inner for  
		   }// End outer for
		   
		   // closing scanner and file reader objects
		   number.close();
		   fr.close();
	   }
	   
	   public static int findMax(int[][] matrix){
		   
		   // taking first value as reference
		   int max = matrix [0][0];
		   // nested loop to iterate inside the table
		   for (int i = 0; i < matrix.length; i++) {
			   for (int j = 0; j < matrix[i].length; j++) {
				   // if statement to save the biggest number
				   if(max < matrix[i][j]) {
					   max = matrix[i][j];
				   }
				   else {
					   return max;
				   }
			   }// End inner for
		   }// End outer for
		   
		   return max;
		   
	   }
	   
	   public static int findMin(int[][] matrix){
		   
		   // taking first value as reference
		   int min = matrix [0][0];
		   // nested loop to iterate inside the table
		   for (int i = 0; i < matrix.length; i++) {
			   for (int j = 0; j < matrix[i].length; j++) {
				// if statement to save the smallest number
				   if(min > matrix[i][j]) {
					   min = matrix[i][j];
				   }
				   else {
					   return min;
				   }
			   }// End inner for
		   }// End outer for
		 
		   return min;
		   
	   }
	   
	   public static int findMaxOfRow(int[][] matrix, int row) {
		   
		// taking first value as reference
		   int maxOfRow = matrix [row][0];
		   // loop to iterate inside the row
		   for (int j = 0; j < matrix.length; j++) {
			   // if statement to save the biggest number
			   if(maxOfRow < matrix[row][j]) {
			   maxOfRow = matrix[row][j];
			   }
			   else {
				   
				   return maxOfRow;
			   }
		   }// End for loop
		   return maxOfRow;
		}
	  
	   public static int findMinOfRow(int[][] matrix, int row) {
		   
		// taking first value as reference
		   int minOfRow = matrix [row][0];
		   // loop to iterate inside the row
		   for (int j = 0; j < matrix.length; j++) {
			   // if statement to save the smallest number
			   if(minOfRow > matrix[row][j]) {
				   minOfRow = matrix[row][j];
			   }
			   else {
				   
				   return minOfRow;
			   }
		   }// End for loop
		   return minOfRow;
		}
	   
	   public static int findMaxOfColumn(int[][] matrix, int column) {
		   
		// taking first value as reference
		   int maxOfCol = matrix [0][column];
		   // loop to iterate inside the column
		   for (int i = 0; i < matrix[i].length; i++) {
			   // if statement to save the biggest number
			   if(maxOfCol < matrix[i][column]) {
				   maxOfCol = matrix[i][column];
			   }
			   else {
				   
				   return maxOfCol;
			   }
		   }// End for loop
		   return maxOfCol;
		}
	
	   
	   public static int findMinOfColumn(int[][] matrix, int column){
		   
		// taking first value as reference
		   int minOfCol = matrix [0][column];
		   // loop to iterate inside the column
		   for (int i = 0; i < matrix[i].length; i++) {
			   // if statement to save the smallest number
			   if(minOfCol > matrix[i][column]) {
				   minOfCol = matrix[i][column];
			   }
			   else {
				   
				   return minOfCol;
			   }
		   }// End for loop
		   return minOfCol;
	
	   }
// Exercise 3:
	   
	   // method to read and group data in column major order
	   public static int [][] colOrder () throws IOException {
		// creating the matrix
		   int [][] colOrder = new int [50][20];
		   // Creating scanner and a file reader object to read the file
		   FileReader fr   = new FileReader("number_list.txt");
		   Scanner number = new Scanner(fr);
		   // nested loop to fill the table with the numbers
		   for (int j = 0; j < colOrder[0].length; j++) {
			   for (int i = 0; i < colOrder.length; i++) {
				   // introducing the numbers into the table
				   colOrder[i][j] = number.nextInt();
			   }// End inner for  
		   }// End outer for
		   
		   // closing scanner and file reader objects
		   number.close();
		   fr.close();
		   
		   return colOrder;
	   }
	   // Not finished Method 
	   /*public static void printRow(int[][] matrix, int row, int num_cols){
		   
		   //length of the rows in the printed matrix
		   double size = Math.ceil(((matrix[row].length/num_cols)));
		   int sizeInt = (int)size;
		   // creating the printRow matrix
		   int [][] printRow = new int [sizeInt][num_cols];
		   // nested loop to fill the table with the numbers
		   for (int i = 0; i < matrix[row].length; i++) {
				for (int j = 0; j < num_cols; j++) {
					// introducing the numbers into the table
					printRow[i - (i * sizeInt)][j] = matrix[row][i];
				}// End inner for  
			}// End outer for
		   System.out.println(printRow);
	   }*/
	   
	   public static int smallestChange(int[][] matrix){
		   // reference value
		   int smallestChange = 0;
		   // for loop to iterate in each row
		   for (int i = 0; i < matrix.length; i++) {
			   // calling method to obtain percent change arrays  
			   matrix [i]= percentChange(matrix[i]);
			   
				}// End for loop
		   // for loop to get max and min values from each percent change array
		   for (int i = 1; i < matrix.length; i++) {
			   // if statement to compare the difference between the max and the min change
			   if((findMax(matrix[i]) - findMin(matrix[i])) < (findMax(matrix[i-1]) - findMin(matrix[i-1]))){
				   smallestChange = i;
			   }
			   else {
				   return smallestChange;
			   }
			   }// End for loop
		   
		   return smallestChange;
		   
		   
	   }
	   // main method to test the code
	   public static void main(String[] args) throws IOException {
		   // Exercise 1:
		   int[] array = array1D();
		   System.out.println(Arrays.toString(array));
		   System.out.println(findMax(array));
		   System.out.println(findMin(array));
		   System.out.println(Arrays.toString(percentChange(array)));
		   // Exercise 2:
		   int[][] matrixRow = rowOrder();
		   System.out.println(Arrays.deepToString(matrixRow).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		   System.out.println(findMax(matrixRow));
		   System.out.println(findMin(matrixRow));
		   System.out.println(findMaxOfRow(matrixRow,2));
		   System.out.println(findMinOfRow(matrixRow,2));
		   System.out.println(findMaxOfColumn(matrixRow,2));
		   System.out.println(findMinOfColumn(matrixRow,2));
		   // Exercise 3:
		   int[][] matrixCol = colOrder();
		   System.out.println(Arrays.deepToString(matrixCol).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		   System.out.println(smallestChange(matrixCol));
		   
	   }
}
