import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElectionTest {

	void test() {
		ElectionDriver test = new ElectionDriver();
		String [] arrTest = {"AK","2697087","3781977","1084890","Republicans"};
		
		;
		assertEquals("Los Angeles County" , test.findLargestMargin());
		assertEquals("Baldwin County" , test.findLargestMargin("AL"));
		assertEquals(arrTest , test.getStateTotals());
	}

}
