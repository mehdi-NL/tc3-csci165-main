
public abstract class Animal {
	
	private int life;
	public  String color;
	private int health;
	private Coordinates [] rangeVision;
	private Coordinates position;
	
	public Animal(Coordinates position) {
		this.life   = 0;
		this.health = 100;
		setRangeVision(rangeVision);
		setPosition(position);

	}

	public int isAlive() {
		return this.health;
	}

	public void setLife(int life) {
		this.life = life;
	}

	
	public String getColor() {
		return this.color;
	}
	
	public void setColor() {};

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Coordinates[] getRangeVision() {
		return this.rangeVision;
	}

	public void setRangeVision(Coordinates[] rangeVision) {
		this.rangeVision = rangeVision;
	}

	public Coordinates getPosition() {
		return this.position;
	}

	public void setPosition(Coordinates position) {
		
		this.position = position;
	}
	
	public void setAllNull() {
		this.color       = null;
		this.health		 = 0;
		this.life		 = 0;
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
	public abstract void duplicate();
	
	public abstract void move();
	
	public abstract void setRange();
	
	public abstract void status();
	

}
