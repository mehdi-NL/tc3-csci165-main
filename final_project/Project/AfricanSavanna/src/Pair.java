
public class Pair{

    private Animal animal;
    private Coordinates habitat;
    private String color;

    public Pair(){
    	animal = null;
    	habitat = null;
    	setColor();		//if coordenate then String color
    }
    
    public Pair(Coordinates secondItem){
    	animal = null;
        habitat = secondItem;
    }

    public Pair(Animal firstItem, Coordinates secondItem){
    	animal = firstItem;
        habitat = secondItem;
    }

    public void setFirst(Animal newFirst){
    	animal = newFirst;
    }

    public void setSecond(Coordinates newSecond){
    	habitat = newSecond;
    }

    public Animal getFirst(){
        return animal;
    }

    public Coordinates getSecond(){
        return habitat;
    }
    
    public Pair getPAir(Coordinates position) {
		return null;
    	
    }

    public String toString(){
  
        return  getFirst().toString() + getSecond().toString() ;
    }
}

