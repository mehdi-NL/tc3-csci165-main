// Mehdi, Nya Louhaichy

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MapDataDrawer {
	
	 static String mapName = getMap();
	 
	 static int [][] map = mapDataDrawer(mapName, getRow(mapName), getCol(mapName));
	 
	public static void main(String[] args)  {
		
		//int [][] matrix = mapDataDrawer(args[0],getRow(args[0]),getCol(args[0]));
		//int max = findMax(matrix);
		//int min = findMin(matrix);
		//public String map = args[0];
		//int[][] matrix = MapDataDrawer(map,getRow(map),getCol(map));
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }

	   });
	}// end main
	
	//private static final String map = args[0];
	//public static int[][] matrix = MapDataDrawer(getMap(),getRow(map),getCol(map));
	
	public static String getMap() {
		Scanner map = new Scanner(System.in);
		System.out.println("Insert full filename: ");
		String getMap = map.nextLine();
		map.close();
		return getMap;
		
	}
	public static int getRow (String map) {
		// Parsing the file name to get the rows and the columns
		// Substring of the input
		String parts = map.substring(13, 16);
		System.out.println(parts);		
		// Getting the columns part of the filename 
		int rows = Integer.parseInt(parts);
		return rows;
	}
	public static int getCol (String map) {
		// Parsing the file name to get the rows and the columns
		// Substring of the input
		String parts = map.substring(9, 12);
		System.out.println(parts);
		// Getting the columns part of the filename 
		int cols = Integer.parseInt(parts);
		return cols;
	}
	public static int[][] mapDataDrawer(String filename, int rows, int cols) {
		
		try {
		// instance of the new 2D array with the right size
		int [][] mapData = new int [rows][cols];
		// Creating scanner and a file reader object to read the file
		FileReader fr   = new FileReader(filename);
		Scanner number = new Scanner(fr);
		// nested loop to fill the table with the numbers
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[i].length; j++) {
				// introducing the numbers into the table
				mapData[i][j] = number.nextInt();
			}// End inner for
		}// End outer for
		
		// closing scanner and file reader objects
		number.close();
		fr.close();
		int [][] map = mapData;
		return map;
		} catch (IOException e) {
			e.printStackTrace();
			return map;
			}
		}
	public static int findMin(int [][] matrix) {
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
	public static int findMax(int [][] matrix) {
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
	
	public void drawMap(Graphics g) {
		
		int BLACK = findMin(mapDataDrawer(getMap(), map.length, map[0].length));
		int WHITE = findMax(map);
		int GRAY_LOW = WHITE - (((WHITE-BLACK)/3)*2);
		int GRAY_HIGH = WHITE - (((WHITE-BLACK)/3));
		int x = 0, y = 0;
		
		for(int c = 0; c < map[0].length; c++) {
        	for(int r = 0; r < map.length; r++) {
        		if(BLACK <= map[r][c] && map[r][c] < GRAY_LOW) {
        			g.setColor(Color.black);
	        		g.fillRect(x, y, 1, 1);
	                y += 1;
	                x += 1;
                 }
        		if(GRAY_LOW <= map[r][c] && map[r][c] <= GRAY_HIGH) {
        			g.setColor(Color.gray);
	        		g.fillRect(x, y, 1, 1);
	                y += 1;
	                x += 1;
                 }
        		if(GRAY_HIGH < map[r][c] && map[r][c] <= WHITE) {
        			g.setColor(Color.white);
	        		g.fillRect(x, y, 1, 1);
	                y += 1;
	                x += 1;
                 }
        	}
        }
		
	}
	
	public int indexOfMinRow(int col) {
		
		
		return col;
		
		
		
	}
	
	public int drawLowestElevPath(Graphics g, int row) {
		return row;
		
		
		
	}
	
	public int indexOfLowestElevPath(Graphics g) {
		return 0;
		
		
		
	}
	


}// end class

