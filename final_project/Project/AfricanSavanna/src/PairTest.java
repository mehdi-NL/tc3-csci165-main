//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PairTest {

	@Test
	void testPairHabitat() {
		Coordinates position = new Coordinates(0,1);
		Habitat     habitat  = new Habitat(position);
		Pair        pair     = new Pair(habitat);
		
		String 		color 	 = pair.getColor();
		Coordinates location = pair.getPosition();
		String      property = habitat.getProperty();
		
		Assert.assertTrue(position.equals(location));
		Assert.assertTrue(color.equalsIgnoreCase("yellow"));
		Assert.assertTrue(property.equalsIgnoreCase("none"));
		
	}

	@Test
	void testPairAnimalHabitat() {
		Coordinates position = new Coordinates(0,0);
		Animal 		lion 	 = new Lion (position);
		Habitat     habitat  = new Habitat(position);
		Pair        pair     = new Pair(lion, habitat);
		
		String 		color 	 = pair.getColor();
		Coordinates location = pair.getPosition();
		String      property = habitat.getProperty();
		
		Assert.assertTrue(lion instanceof Lion);
		Assert.assertTrue(position.equals(location));
		Assert.assertTrue(color.equals(lion.getColor()));
		Assert.assertTrue(property.equalsIgnoreCase("none"));
	}

}
