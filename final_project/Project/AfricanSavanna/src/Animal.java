
public abstract class Animal {
	
	private int life;
	private String color;
	private int health;
	private Coordinates [] rangeVision;
	private Coordinates position;
	
	
	public Animal(Coordinates position, String color) {
		this.life        = 0;
		setColor();
		this.health      = 100;
		setRangeVision(rangeVision);
		setPosition(position);

	}

	public int isAlive() {
		return health;
	}

	public void setLife(int life) {
		this.life = life;
	}

	
	public String getColor() {
		return color;
	}
	
	public void setColor() {
		if(this.color == "orange" || this.color == "ORANGE") {
			if(getHealth() >= 70) {
				this.color =  "orange";
			}
			if( 40 <= getHealth() || getHealth() < 70) {
				this.color =  "pink";
			}
			if(0 < getHealth() || getHealth() < 40) {
				this.color =  "red";;
			}
		}
		
		if(this.color == "gray" || this.color == "GRAY") {
			if(getHealth() >= 70) {
				this.color =  "gray";
			}
			if( 40 <= getHealth() || getHealth() < 70) {
				this.color =  "lightGray";
			}
			if(0 < getHealth() || getHealth() < 40) {
				this.color =  "red";
			}
		}
			
		else {
				this.color =  "black";
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Coordinates[] getRangeVision() {
		return rangeVision;
	}

	public void setRangeVision(Coordinates[] rangeVision) {
		this.rangeVision = rangeVision;
	}

	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		
		this.position = position;
	}
	
	public void setAllNull() {
		this.color       = null;
		this.health		 = (Integer) null;
		this.life		 = (Integer) null;
		this.position	 = null;
		this.rangeVision = null;
	}
	
	
	/*-----------------------------------------------*/
	public void die() {
		
		if(health == 0) {
			setAllNull();
		}
		
		if(life == 100) {
			setAllNull();
		}
			
	}
	
	public abstract void move();
	
	public abstract void setRange();
	
	public abstract void status();
	

}
