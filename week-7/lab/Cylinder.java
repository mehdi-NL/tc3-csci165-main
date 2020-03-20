//Mehdi, Nya Louhaichy
//03/15/2020

public class Cylinder extends Circle {
	
	private double height;
	
	public Cylinder() {
		// calling the super class constructor
		super();
		height = 1.0;
		
	}
	
	public Cylinder(double height) {
		// calling the super class constructor
		super();
		this.height = height;
		
	}
	
	public Cylinder(double radius, double height) {
		// calling the super class constructor
		super(radius);
		this.height = height;
		
	}
	
	public Cylinder(Point center, double radius, double height) {
		// calling the super class constructor
		super(center,radius);
		this.height = height;
		
	}
	
	public double getHeight() {
		
		return height;
		
	}
	
	public double getVolume() {
		// calling getArea from circle
		return getArea() * height;
		
	}
	@Override
	public String toString() {
		//calling super class toString method
		return super.toString() +
			   ", height: " + height ;
		
	}
	
	public boolean equals(Cylinder other) {
		// calling super class equals
		return super.equals(other) &&
				Double.compare(height, other.getHeight()) == 0;
		
		
		
	}

}
