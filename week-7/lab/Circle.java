//Mehdi, Nya Louhaichy
//03/15/2020


public class Circle {
	
	private Point center;
	private double radius;
	
	public Circle (double radius) {
		// calling the empty constructor from Point
		Point center = new Point();
		this.radius = radius;
		this.center = center;
		
	}
	
	public Circle(Point center, double radius) {
		
		this.center = center;
		this.radius = radius;
		
	}
	
	public Circle(int x, int y, double radius) {
		// creating a point with the given x and y
		Point center = new Point(x, y);
		new Circle(center, radius);
		
	}
	
	public Circle() {
		// values for the empty constructor
		this.center = new Point();
		this.radius = 1;
		
	}
	// clone constructor
	public Circle(Circle copy) {
		
		this.center = copy.center;
		this.radius = copy.radius;
		
	}
	
	public double getRadius() {
		return radius;	
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getCenterX() {
		return center.getX();
	}
	
	public void setCenterX(int x) {
		this.center.setX(x);
	}
	
	public int getCenterY() {
		return center.getY();
	}
	
	public void setCenterY(int y) {
		this.center.setY(y);
	}
	
	public int[] getCenterXY() {
		return center.getXY();
	}
	
	public void setCenterXY(int x, int y) {
		this.center.setX(x);
		this.center.setY(y);
	}
	
	@Override
	public String toString() {
		// uses toString from Point for the center
		return "Radius = " + radius
				+ ", center = " + center.toString(); 
		
	}
	
	public double getArea() {
		// area formula 
		return Math.PI * Math.pow(radius, 2);
		
	}
	
	public double getCircumference() {
		// circumference formula
		return 2 * Math.PI * radius;
		
	}
	
	public double distance (Circle another) {
		// uses distance method from Point
		return center.distance(another.center);
		
	}
	
	public boolean equals(Object obj) {
		// identity check
        if (this == obj)                    return true;
        // null check
        if (obj == null)                    return false;
        // origin check
        if (getClass() != obj.getClass())   return false;
		
        Circle other = (Circle) obj;                  // down cast
        return  center.equals(other.getCenter()) &&
        		Double.compare(radius, other.getRadius()) == 0;
		 
	}
	
	
}// End Class
