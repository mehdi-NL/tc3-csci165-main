
	import java.awt.EventQueue;

	import java.awt.Graphics;

	import java.awt.Graphics2D;
import java.text.Format.Field;

import javax.swing.JFrame;

	import javax.swing.JPanel;

	import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;



	class Drawer extends JPanel {
		

	    private static final long serialVersionUID = 1L;

	    private JFrame window = new JFrame();
	    
	    public static Pair [][] pairs;

	    public Drawer() throws InterruptedException {

	        initUI();
	        firstMap();
	        newMap();
	        

	    }
	    
	    public void setPairs() {
	    	pairs = new Pair[100][100];
	    	for(int i = 0; i < pairs.length; i++){
	            for(int j = 0; j < pairs.length; j++){
	            	Coordinates position = new Coordinates(i,j);
	            	Habitat     habitat  = new Habitat(position);
	            	
	            	pairs [i][j] = new Pair(habitat);
	            }
	        }
	    	
	    }
	    
	    private void firstMap() {
	    	setPairs();
	    	Coordinates pos1  = new Coordinates (1, 5);
	    	Lion 		lion1 = new Lion(pos1);
	    	pairs [10][5].setAnimal(lion1);
	    	Coordinates pos2  = new Coordinates (1, 15);
	    	Lion 		lion2 = new Lion(pos2);
	    	pairs [1][15].setAnimal(lion2);
	    	Coordinates pos3  = new Coordinates (1, 35);
	    	Lion 		lion3 = new Lion(pos3);
	    	pairs [10][35].setAnimal(lion3);
	    	Coordinates pos4  = new Coordinates (1, 55);
	    	Lion 		lion4 = new Lion(pos4);
	    	pairs [1][55].setAnimal(lion4);
	    	Coordinates pos5  = new Coordinates (1, 75);
	    	Lion 		lion5 = new Lion(pos5);
	    	pairs [10][75].setAnimal(lion5);
	    	
	    	
	    	Coordinates pos6 = new Coordinates (80, 5);
	    	Gazelle 	gaz1 = new Gazelle(pos6);
	    	pairs [85][5].setAnimal(gaz1);
	    	Coordinates pos7 = new Coordinates (80, 15);
	    	Gazelle 	gaz2 = new Gazelle(pos7);
	    	pairs [80][15].setAnimal(gaz2);
	    	Coordinates pos8 = new Coordinates (80, 35);
	    	Gazelle 	gaz3 = new Gazelle(pos8);
	    	pairs [85][35].setAnimal(gaz3);
	    	Coordinates pos9 = new Coordinates (80, 55);
	    	Gazelle 	gaz4 = new Gazelle(pos9);
	    	pairs [80][55].setAnimal(gaz4);
	    	Coordinates pos10 = new Coordinates (80, 75);
	    	Gazelle 	gaz5 = new Gazelle(pos10);
	    	pairs [85][75].setAnimal(gaz5);
	    	
	    	
	    	
	    }
	    
	    private void newMap() {
	    	ArrayList <Lion> lions = new ArrayList<Lion>();
	    		if(lions.size() > 20) {lions.remove(0);}
	    	ArrayList <Gazelle> gazelles = new ArrayList<Gazelle>();
	    		if(lions.size() > 20) {gazelles.remove(0);}
	    	for(Pair [] line: pairs) {
				for(Pair pair: line) {
					if(pair.getAnimal() instanceof Lion ) {
						lions.add((Lion) pair.getAnimal());
					}
					if(pair.getAnimal() instanceof Gazelle ) {
						gazelles.add((Gazelle) pair.getAnimal());
					}
					else {continue;}
				}
			}
	    	
	    	setPairs();
	    	
	    	for(Lion one: lions) {
	    		one.status();
	    		int row = one.getPosition().getRow();
	    		int col = one.getPosition().getColumn();
	    		pairs [row][col].setAnimal(one);
	    	}
	    	for(Gazelle two: gazelles) {
	    		two.status();
	    		int row = two.getPosition().getRow();
	    		int col = two.getPosition().getColumn();
	    		pairs [row][col].setAnimal(two);
	    	}
	    }

	    private void initUI() {

	        window.add(this);

	        window.setTitle("Savanna");

	        window.setSize(1000, 1000);

	        window.setLocationRelativeTo(null);

	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        window.setVisible(true);

	    }



	    @Override

	    public void paintComponent(Graphics g) {
	    	
	        super.paintComponent(g);

	        try {
				doDrawing(g);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	    
	    private void doDrawing(Graphics g) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {


	        Graphics2D g2d = (Graphics2D) g;

	        firstMap();
		        for(int i = 0; i < 100; i++){
		            for(int j = 0; j < 100; j++){
		            	String text = pairs[i][j].getColor();
		            	Color color;
		            	java.lang.reflect.Field field = Class.forName("java.awt.Color").getField(text.toLowerCase()); // toLowerCase because the color fields are RED or red, not Red
		            	color = (Color)field.get(null);
		                g2d.setColor(color);
		                g2d.fillRect(j*10 , i*6 , 10 , 10 ); // draws in column major order
		            }
		        }
	        }

	    public static void main(String[] args) {
	    	
	        
	    	
	        EventQueue.invokeLater(new Runnable() {

	            @Override

	            public void run() { 

	                Drawer ex = null;
					try {
						ex = new Drawer();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	                ex.setVisible(true);

	            }

	        });

	    } // end main

	} // end class
