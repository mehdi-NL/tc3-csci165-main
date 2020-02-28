
public class Temperature {
	
	// static class features
    public static enum          Scale{C, F};                 
     
    
    // non-static instance features
    // each instance will get unique copies of these variables
    // this information should be hidden from public access
    private float   temp  = 0;
    private Scale	scale = Scale.C;
    
    // constructors: define various ways for instances to be created
    public Temperature(){} // no argument constructor

    public Temperature(Scale C){
        setScale(scale);
    }
    
    public Temperature(float temperature){
        setTemperature(temperature);
    }

    public Temperature(Scale scale, float temperature){
        // call overloaded constructor
        this.scale = scale;
        this.temp = temperature;
    }
    
    // method to return the temperature
    public float getCelsius() {
		if (this.scale == Scale.C) {
			return temp;
		}
		else  {
			temp = (5*(temp-32))/9;
			return temp;
			}
    }
    
    // method to return the temperature
    public float getFahrenheit() {
		if (this.scale == Scale.F) {
			return temp;
		}
		else  {
			temp = (9*(temp)/5)+32;
			return temp;
			}
    }
    // method to set temperature value
    public void setTemperature(float temperature) {
    	this.temp = temperature;
    }
    // method to set the scale
    public void setScale(Scale scale) {
    	this.scale = scale;
    }
    // method to set the scale and the temperature
    public void setScaleTemp(Scale scale, float temperature) {
    	this.scale = scale;
    	this.temp = temperature;
    }
    // equals method to compare two temperatures
    public boolean equals(Temperature t) {
    	if (t.getCelsius() == this.temp || 
    		t.getFahrenheit() == this.temp) {
    		return true;
    	}
    	else {
    	return false;
    	}
    }
    // method to determine sorting order of temperatures
    public int compareTo(Temperature t) {
    	int compared = 0;
    	if ( this.scale == Scale.C) {
    		if ( this.temp > t.getCelsius() ) {
    			compared = 1;
    			return compared;
    			}
    		if (this.temp < t.getCelsius()) {
    			compared = -1; 
    			return compared;
    			}
    	}
    	if( this.scale == Scale.F) {
    		if ( this.temp > t.getFahrenheit() ) {
    			compared = 1;
    			return compared;
    			}
    		if (this.temp < t.getFahrenheit()) {
    			compared = -1; 
    			return compared;
    			}
    	}
    	else {
    		return compared;
    	}
		return compared;
    }// End method

    // suitable to string method
	public String toString() {
		return "The temperature is " + this.temp + " in the scale " + this.scale;
	}
    
    
    
    
}// End Class

