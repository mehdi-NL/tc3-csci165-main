//Mehdi, Nya Louhaichy
//03/15/2020

public class Driver {
	
	public static void main(String[] args){
		// Points
		Point [] points = new Point [10];
		for( int i = 0; i < points.length; i++) {
			
			points [i] = new Point(i+1,i+1);
			
		}
		
		for(int j = 0;j < points.length; j++) {
			
			System.out.println(points[j].toString());
			
		}
		//Circles
		Circle [] circles = new Circle [10];
		for( int i = 0; i < circles.length; i++) {
			
			circles [i] = new Circle(points[i],i+1);
			
		}
		
		for(int j = 0;j < circles.length; j++) {
			
			System.out.println(circles[j].toString());
			
		}
		
		// Cylinder
		Cylinder cylin1 = new Cylinder ();
		Cylinder cylin2 = new Cylinder (2.5);
		Cylinder cylin3 = new Cylinder (points[2],3.5,5.5);
		Cylinder cylin4 = new Cylinder (4.5,6.5);
		Cylinder cylin5 = new Cylinder (5.5,7.5);
		
		System.out.println("Cylin2 center is: " + 
							cylin2.getCenter().toString());
		System.out.println("Distance between cylin1 and cylin3 is : " +
							cylin1.distance(cylin3));
		System.out.println("Area of the base of cylin3 is: "
							+cylin3.getArea());
		
		// Polymorphism
		Circle [] collection = new Circle [10];
		for(int c = 0;c < 5;c++) {
			collection[c] = circles[c];
		}
		collection[5] = cylin1;
		collection[6] = cylin2;
		collection[7] = cylin3;
		collection[8] = cylin4;
		collection[9] = cylin5;
		
		for(int e=0; e < collection.length; e++) {
			System.out.println(collection[e].toString());
			//collection[e].getVolume;
		}
		
		Object [] inherit = new Object [9];
		inherit[0] = points[0];
		inherit[1] = points[1];
		inherit[2] = points[2];
		inherit[3] = circles[0];
		inherit[4] = circles[1];
		inherit[5] = circles[2];
		inherit[6] = cylin1;
		inherit[7] = cylin2;
		inherit[8] = cylin3;
		
		for(int e=0; e<inherit.length; e++) {
			System.out.println(inherit[e].toString());
			//inherit[e].getHeight;		method not valid for all the objects
		}
		
		System.out.println(points[0].equals(points[0]));  //True
		System.out.println(points[0].equals(points[1]));  //False
		System.out.println(inherit[6].equals(inherit[6]));//True
		System.out.println(inherit[7].equals(inherit[6]));//True
		
		//Experiment
		Object [] objects = new Object [4];
		objects[0] = inherit[1];
		objects[1] = inherit[4];
		objects[2] = inherit[7];
		objects[3] = new Date(3,19,2020);
		
		for(int e=0; e<objects.length; e++) {
			System.out.println(objects[e].toString());
			//inherit[e].getHeight;		method not valid for all the objects
		}
		
	}

}
