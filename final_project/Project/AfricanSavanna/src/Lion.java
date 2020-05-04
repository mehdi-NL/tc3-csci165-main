
public class Lion extends Animal{
	
	private boolean hunter;
	private int sharpTeeth;
	private Coordinates [] rangeVision;
	
	public Lion(Coordinates position, String color) {
		super(position,color);
		
		this.hunter      = false;
		this.sharpTeeth  = 100;
		setRange();
		
	}
	
	public void setRange() {
		
		int animalRow = getPosition().getRow();
		int animalCol = getPosition().getColumn();
		
		if(animalCol > 0 && animalCol < 99) {
			Coordinates point1 = new Coordinates (animalRow + 1, animalCol -1);
			Coordinates point2 = new Coordinates (animalRow + 1, animalCol   );
			Coordinates point3 = new Coordinates (animalRow + 1, animalCol +1);
			Coordinates point4 = new Coordinates (animalRow + 2, animalCol -1);
			Coordinates point5 = new Coordinates (animalRow + 2, animalCol   );
			Coordinates point6 = new Coordinates (animalRow + 2, animalCol +1);
			
			Coordinates [] rangeVision = {point1, point2, point3, point4, point5, point6};
			this.rangeVision = rangeVision;
		}
		if(animalCol == 0 ) {
			//Coordinates point1 = new Coordinates (animalRow + 1, animalCol -1);
			Coordinates point2 = new Coordinates (animalRow + 1, animalCol   );
			Coordinates point3 = new Coordinates (animalRow + 1, animalCol +1);
			//Coordinates point4 = new Coordinates (animalRow + 2, animalCol -1);
			Coordinates point5 = new Coordinates (animalRow + 2, animalCol   );
			Coordinates point6 = new Coordinates (animalRow + 2, animalCol +1);
			
			Coordinates [] rangeVision = {point2, point3, point5, point6};
			this.rangeVision = rangeVision;
		}
		if(animalCol == 99 ) {
			Coordinates point1 = new Coordinates (animalRow + 1, animalCol -1);
			Coordinates point2 = new Coordinates (animalRow + 1, animalCol   );
			//Coordinates point3 = new Coordinates (animalRow + 1, animalCol +1);
			Coordinates point4 = new Coordinates (animalRow + 2, animalCol -1);
			Coordinates point5 = new Coordinates (animalRow + 2, animalCol   );
			//Coordinates point6 = new Coordinates (animalRow + 2, animalCol +1);
			
			Coordinates [] rangeVision = {point1, point2, point4, point5};
			this.rangeVision = rangeVision;
		}
		
	}
	
	public void status() {
		
		if(getHealth() > 50) {
			move();
		}
		if(getHealth() > 0 && getHealth() <= 50) {
			this.hunter = true;
			move();
		}
		
	}
	
	public void move() {
		// use coordinates class
		// Add one random nearby position if hunter == false
		status();
		int row = getPosition().getRow() ;
		int column = getPosition().getColumn();
		int randomInt = (int)((Math.random()*2) - 1);
		
		if(hunter == false && row < 33) {
			if(row == 32) {
				getPosition().setCoordinates(row -1 , randomInt);
				setPosition(getPosition()) ;
			}
			if(row == 0) {
				getPosition().setCoordinates(row + 1 , randomInt);
				setPosition(getPosition()) ;
			}
			if(column == 99) {
				getPosition().setCoordinates(randomInt , column - 1);
				setPosition(getPosition()) ;
			}
			if(column == 0) {
				getPosition().setCoordinates(randomInt , column + 1);
				setPosition(getPosition()) ;
			}
		}
		if(hunter == false && row > 32) {
			//setHealth(100);
			getPosition().setCoordinates(row -1 , randomInt);
			setPosition(getPosition()) ;
		}
		else {
			if(row < 65) {
				getPosition().setCoordinates(row + 1, column);
				setPosition(getPosition()) ;
			}
			else {
				getPosition().setCoordinates(65, column);
				setPosition(getPosition()) ;
				attack();
			}
		}
	}
	// working on attack method
	public void attack() {
		
		int animalRow = getPosition().getRow();
		int animalCol = getPosition().getColumn();
		
		Coordinates point1 = new Coordinates (animalRow + 1, animalCol -1);
		Coordinates point2 = new Coordinates (animalRow + 1, animalCol   );
		Coordinates point3 = new Coordinates (animalRow + 1, animalCol +1);
		Coordinates point4 = new Coordinates (animalRow + 2, animalCol -1);
		Coordinates point5 = new Coordinates (animalRow + 2, animalCol   );
		Coordinates point6 = new Coordinates (animalRow + 2, animalCol +1);
		
		//for(Pair [] pairRange:  ) {
			
		//}
		
		
	}
	
	
}