package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoTest {
	private Auto auto;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test()
	{
		assertThrows(IllegalArgumentException.class,()->new Auto("E-AR-234", "Opel", 65, "Corsa", null));
	}

	@Test
	void test1() {
		String inputString [] = {"20241214_20241216", "20241217_20241219"};
		auto = new Auto("E-AR-234", "Opel", 65, "Corsa", inputString);
		BooleanSupplier test = ()-> auto.getkennzeichen().equals("E-AR-234");
		assertTrue(test,"E-AR-234");
	}

}
