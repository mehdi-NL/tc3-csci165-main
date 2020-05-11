import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AtackTest {

	@Test
	void testAtack() {
		Pair [][] testMap = Drawer.pairs.clone();
		Coordinates positionLion = new Coordinates (65,50);
		Coordinates positionGaz  = new Coordinates (66,50);
		Habitat h1  = new Habitat(positionLion);
		Habitat h2  = new Habitat(positionGaz);
		Lion   lion = new Lion(positionLion);
		Gazelle gaz = new Gazelle (positionGaz);
		Pair    one = new Pair(lion, h1);
		Pair    two = new Pair(lion, h2);
		
		
		testMap[65][50] = one;
		testMap[66][50] = two;
		
		lion.setHealth(10);
		
		lion.status();
		gaz.status();
		
		Assert.assertTrue(gaz.getHealth() == 0);
	}

}
