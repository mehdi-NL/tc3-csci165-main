import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HabitatTest {

	@Test
	public void testLand() {
		Coordinates position = new Coordinates(0,0);
		Habitat land 		 = new Habitat (position);
		
		String property   = land.getProperty();
		String color 	  = land.getColor();
		
		Assert.assertTrue(property == "none");
		Assert.assertTrue(color    == "yellow");
	}
	
	@Test
	public void testWater() {
		Coordinates position = new Coordinates(99,0);
		Habitat land 		 = new Habitat (position);
		
		String property   = land.getProperty();
		String color 	  = land.getColor();
		
		Assert.assertTrue(property == "water");
		Assert.assertTrue(color    == "blue");
	}
	
	@Test
	public void testBush() {
		Coordinates position = new Coordinates(40,0);
		Habitat land 		 = new Habitat (position);
		
		String property   = land.getProperty();
		String color 	  = land.getColor();
		
		Assert.assertTrue(property == "invisible");
		Assert.assertTrue(color    == "green");
	}

}

