
public class Habitat {
	
	private String color;
	private Coordinates position;
	private String property;
	
	public Habitat(Coordinates position) {
		
		this.position  	  = position;
		setColorProperty();
		
		
		
	}

	public void setColorProperty() {
		int row = position.getRow();
		
		if(row == 99) {
			this.color = "blue";
			this.property = "water";
		}
		if(row > 32 && row < 66) {
			this.color = "green";
			this.property = "invisible";
		}
		if(row >= 0 && row < 33 || row > 65 && row < 99) {
			this.color = "yellow";
			this.property = "none";
		}
		
		
	}

	public String getColor() {
		return color;
	}

	public Coordinates getPosition() {
		return position;
	}

	public String getProperty() {
		return property;
	}
	

}
