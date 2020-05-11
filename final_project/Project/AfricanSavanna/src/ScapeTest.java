import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ScapeTest {

	@Test
	void testScape() {
		Animal [][] testMap    	 = new Animal [100][100];
		Coordinates positionLion = new Coordinates (90,50);
		Coordinates positionGaz  = new Coordinates (91,50);
		Lion lion   = new Lion(positionLion);
		Gazelle gaz = new Gazelle (positionGaz);
		
		testMap[90][50] = lion;
		
		lion.status();
		gaz.status();
		
		Assert.assertTrue(gaz.getHealth() != 0);
	}

}
