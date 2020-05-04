
public abstract class Habitat {
	
	private int[][] color;
	private int [][] area;
	private String property;
	
	public Habitat(int[][] color, int[][] area, String property) {
		
		this.color 	  = color;
		this.area  	  = area;
		this.property = property;
		
	}
    // check what getters and setters are needed
	public int[][] getColor() {
		return color;
	}

	public void setColor(int[][] color) {
		this.color = color;
	}

	public int[][] getArea() {
		return area;
	}

	public void setArea(int[][] area) {
		this.area = area;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	

}
