

public class Driver {

	public static void main(String[] args) {
		// create a temperature
		Temperature	 temp = new Temperature();
		Temperature	 temp1 = new Temperature(Temperature.Scale.C);
		Temperature	 temp2 = new Temperature(Temperature.Scale.C, 90);
		Temperature	 temp3 = new Temperature(Temperature.Scale.F, 70);
		
		
		System.out.println("This temperature in Celsius is: " + temp.getCelsius());
		System.out.println("Temperature in Fahrenheit: " + temp.getFahrenheit() + 
				", and Celsius: " + temp1.getCelsius());
		System.out.println("We will set temp -> " + temp2.toString());
		// setting temp 2:
		temp2.setTemperature(-19.9F);
		System.out.println("After setting the temp: " + temp2.toString());
		// setting scale temp2:
		temp2.setScale(Temperature.Scale.F);
		System.out.println("After setting the scale: " + temp2.toString());
		System.out.println("Are temp2 and temp3 equals: " + temp2.equals(temp3));
		System.out.println("Which one is bigger temp2 or temp3? " + temp2.compareTo(temp3));
		

	}

}
