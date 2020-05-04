
public class Gazelle extends Animal{
	
	
	private boolean scape;
	private boolean thirst;
	private boolean fear;
	private Coordinates [] rangeVision;
	
	public Gazelle(Coordinates position, String color) {
		super(position, color);
		this.scape = false;
		this.thirst = false;
		this.fear = false;
		setRange();
		
	}
	
	public void setRange() {
		
		int animalRow = getPosition().getRow();
		int animalCol = getPosition().getColumn();
		
		Coordinates point1 = new Coordinates (animalRow - 1, animalCol -1);
		Coordinates point2 = new Coordinates (animalRow - 1, animalCol   );
		Coordinates point3 = new Coordinates (animalRow - 1, animalCol +1);
		Coordinates point4 = new Coordinates (animalRow - 2, animalCol -1);
		Coordinates point5 = new Coordinates (animalRow - 2, animalCol   );
		Coordinates point6 = new Coordinates (animalRow - 2, animalCol +1);
		
		Coordinates [] rangeVision = {point1, point2, point3, point4, point5, point6};
		
		this.rangeVision = rangeVision;
		
	}
	
	public void status() {
		
		if(getHealth() > 50) {
			move();
		}
		if(getHealth() > 0 && getHealth() <= 20) {
			this.thirst = true;
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
		
		if(thirst == false && row < 33) {
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
		if(thirst == false && row > 32) {
			//setHealth(100);
			getPosition().setCoordinates(row -1 , randomInt);
			setPosition(getPosition()) ;
		}
		else {
			if(row < 98) {
				getPosition().setCoordinates(row + 1, column);
				setPosition(getPosition()) ;
			}
			else {
				getPosition().setCoordinates(98, column);
				setPosition(getPosition()) ;
				if(fear) {
					scape();
				}
				else {
					drink();
				}
			}
		}
	}
	
	public void scape() {
		int row = getPosition().getRow() ;
		int column = getPosition().getColumn();
		
		if(getPosition().getRow() != 98) {
			getPosition().setCoordinates(row + 1, column);
			setPosition(getPosition()) ;
		}
		else { fear = false;}
		
		
	}
	
	public void drink() {
		
		if(thirst && getPosition().getRow() == 98) {setHealth(100);}
		
		else { thirst = false; }
		
		
	}
	

}
