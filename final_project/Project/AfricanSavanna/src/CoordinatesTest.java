//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CoordinatesTest {

	@Test
	void testCoordinates() {
		Coordinates position = new Coordinates(0,0);
		
		int x = position.getRow();
		int y = position.getColumn();
		
		Assert.assertTrue(x == 0);
		Assert.assertTrue(y == 0);
	}

}
