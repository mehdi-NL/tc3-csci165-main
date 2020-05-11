
public class Lion extends Animal{
	
	private boolean hunter;
	private int sharpTeeth;
	private Coordinates [] rangeVision;
	
	public Lion(Coordinates position) {
		super(position);
		
		this.hunter      = false;
		this.sharpTeeth  = 100;
		setColor();
		setRange();
		
	}
	
	@Override
	public void setColor() {
		int health = getHealth();
		
		if( health >= 70) {
			this.color =  "orange";
		}
		if( 40 <= health && health < 70) {
			this.color =  "pink";
		}
		if(0 < health && health < 40) {
			this.color =  "red";;
		}
		if ( health == 0){
			this.color =  "black";
		}
		
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
		setHealth(getHealth() - 1);
		//status();
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
			if(row < 65 && hunter == true) {
				getPosition().setCoordinates(row + 1, column);
				setPosition(getPosition()) ;
			}
			else {
				getPosition().setCoordinates(65, column);
				setPosition(getPosition());
				//Check if there is a gazelle
				Pair [][] range = {{Drawer.pairs[row+1][column-1],Drawer.pairs[row+1][column],
							   Drawer.pairs[row+1][column+1]}, {
							   Drawer.pairs[row+2][column-1],
							   Drawer.pairs[row+2][column],Drawer.pairs[row+2][column+1]}};
				
				for(Pair [] line: range) {
					for(Pair prey: line) {
						if(prey.getAnimal() instanceof Gazelle ) {
							attack();
							prey.getAnimal().die();
						}
						else {
							continue;
						}
					}
				}
			}
		}
	}
	// working on attack method
	public void attack() {
		
		int row    = getPosition().getRow();
		int column = getPosition().getColumn();
		
		getPosition().setCoordinates(row + 1, column);
		setPosition(getPosition()) ;
		// restore health
		setHealth(100);
		// end hunter mode
		this.hunter = false;
		
	}
	
	@Override
	public void die() {
		
		setAllNull();
		this.color 		 = null;
		this.hunter 	 = false;
		this.rangeVision = null;
		this.sharpTeeth  = 0;
		
	}
	@Override
	public void duplicate() {
		int row = getPosition().getRow() ;
		int column = getPosition().getColumn();
		
		if(getHealth() == 70) {
			if(column == 99 && Drawer.pairs[row][98].getAnimal().equals(null)) {
				Coordinates positionLion = new Coordinates(row,98);
				Lion lion = new Lion(positionLion);
				Drawer.pairs[row][98].setAnimal(lion);
			}
			if(column == 0 && Drawer.pairs[row][1].getAnimal().equals(null)) {
				Coordinates positionLion = new Coordinates(row,1);
				Lion lion = new Lion(positionLion);
				Drawer.pairs[row][1].setAnimal(lion);
			}
		}
		
	}
	
	
}