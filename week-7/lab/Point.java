//Mehdi, Nya Louhaichy
//03/15/2020

public class Point {
	
	private int x;
	private int y;
	
	public Point() {
		
		this.x = 0;
		this.y = 0;
		
	}
	
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	// copy constructor
	public Point (Point copy){
        this(copy.x, copy.y);
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setXY(int x, int y) {
		
		this.x = x;
		this.y =y;
		
	}
	
	public int [] getXY() {
		// creating and allocating x and y in an int array
		int [] coor = {this.x, this.y};
		return coor;
		
	}
	
	public String toString() {
		
		return "(" + this.x + ", "
				+ this.y +")";
		
	}
	
	public double distance (Point another) {
		// Auxiliary variables
		int x1 = this.x;
		int y1 = this.y;
		int x2 = another.getX();
		int y2 = another.getY();
		//distance formula
		return Math.sqrt(Math.pow((x2-x1), 2) + 
				Math.pow((y2-y1), 2));
		
	}
	
	public double distance (int x, int y) {
		
		int x1 = this.x;
		int y1 = this.y;
		int x2 = x;
		int y2 = y;
		
		return Math.sqrt(Math.pow((x2-x1), 2) + 
				Math.pow((y2-y1), 2));
	}
	
	public double distance () {
		
		int x1 = this.x;
		int y1 = this.y;
		int x2 = 0;
		int y2 = 0;
		
		return Math.sqrt(Math.pow((x2-x1), 2) + 
				Math.pow((y2-y1), 2));
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// identity check
        if (this == obj)                    return true;
        // null check
        if (obj == null)                    return false;
        // origin check
        if (getClass() != obj.getClass())   return false;
		
        Point other = (Point) obj;                  // down cast
        Integer a = other.getX();
        Integer b = other.getY();
        return  a.compareTo(this.x) == 0 &&
        		b.compareTo(this.y) == 0;
		 
	}
	
}
