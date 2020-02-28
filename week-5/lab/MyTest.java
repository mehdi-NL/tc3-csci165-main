import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyTest {
	
	public void temperatureTest() {
		// Creating object Temperature to be tested
		Temperature tester = new Temperature();
		Temperature tester1 = new Temperature(-40.0f);
		Temperature tester2 = new Temperature(100.0f);
		
		// Assert statements
		assertEquals("The temperature is 0 in the scale C",tester.toString());
		assertEquals(0, tester.getCelsius());
		assertEquals(32, tester.getFahrenheit());
		assertEquals(-40.0, tester1.getFahrenheit());
		assertEquals(212.0, tester2.getFahrenheit());
	}

}
