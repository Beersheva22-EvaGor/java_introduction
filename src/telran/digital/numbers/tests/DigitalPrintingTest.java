package telran.digital.numbers.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;


class DigitalPrintingTest {
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(30, 5, 6));
	}
	
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(30,5,6));
	}
	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(30,5,6));
	}
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(30,5,7));
	}
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(30,5,8));
	}
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(30,5,8));
	}
	@Test
	@Disabled
	void sixTest() {
		displayStrings(six(30,5,6));
	}
	@Test
	@Disabled
	void sevenTest() {
		displayStrings(seven(30,5,6));
	}
	@Test
	@Disabled
	void eightTest() {
		displayStrings(eight(30,5,6));
	}
	@Test
	@Disabled
	void nineTest() {
		displayStrings(nine(30,5,6));
	}

	
	@Test
	void displayDigitalNumberTest() {
		displayDigitalNumber(1234567890, 10,5,6);
		System.out.println();
		displayDigitalNumber(456123, 10,5,6);
	}
}
