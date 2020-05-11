//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void testLion() {
		Coordinates position = new Coordinates(0,0);
		Animal lion = new Lion (position);
		
		int health   = lion.getHealth();
		String color = lion.getColor();
		
		Assert.assertTrue(health == 100);
		Assert.assertTrue(color  == "orange");
	}
	
	@Test
	void testGazelle() {
		Coordinates position = new Coordinates(98,0);
		Animal gazelle 		 = new Gazelle (position);
		
		int health   = gazelle.getHealth();
		String color = gazelle.getColor();
		
		Assert.assertTrue(health == 100);
		Assert.assertTrue(color  == "gray");
	}

}
