
public class Pair{

    private Animal animal;
    private Habitat habitat;
    private String color;
    private Coordinates location;

    
    public Pair(Habitat habitat){
    	this.animal   = null;
        this.habitat  = habitat;
        this.location = habitat.getPosition();
        setColor();
    }

    public Pair(Animal animal, Habitat habitat){
    	this.animal  = animal;
        this.habitat = habitat;
        this.location = habitat.getPosition();
        setColor();
    }
    
    public void setAnimal(Animal newAnimal){
    	this.animal = newAnimal;
    	this.location = habitat.getPosition();
    	setColor();
    }

    public void setHabitat(Habitat newHabitat){
    	this.habitat = newHabitat;
    	setColor();
    }

    public Animal getAnimal(){
        return animal;
    }

    public Habitat getHabitat(){
        return habitat;
    }

    public String toString(){
  
        return  getAnimal().toString() + getHabitat().toString() ;
    }
    
    public void setColor() {
    	if(animal instanceof Animal) {
    		this.color = animal.getColor();
    	}
    	else {
    		this.color = habitat.getColor();
    	}
    }
    
    public String getColor() {
    	setColor();
    	return color;
    }
    
    public Coordinates getPosition() {
    	
    	return habitat.getPosition();
    	
    }
    
}

