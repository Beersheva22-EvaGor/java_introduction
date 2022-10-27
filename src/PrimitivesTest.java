import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test 
	@Disabled
	void operatorTest() {	
		int number = 123;
		/*
		 * assertEquals(3, getThirdDigit(number)); 
		 * assertEquals(2,getSecondDigit(number)); 
		 * assertEquals(1, getFirstDigit(number));
		 */
		assertEquals(3, getDigit(number, 3));
		assertEquals(2, getDigit(number, 2));
		assertEquals(1, getDigit(number, 1));
		
	}
	// Primitive method
	/*
	 * private int getFirstDigit(int number) { return getThirdDigit((number -
	 * getSecondDigit(number))/100); }
	 * 
	 * private int getSecondDigit(int number) { return getThirdDigit((number -
	 * getThirdDigit(number))/10); }
	 * 
	 * private int getThirdDigit(int number) { return number%10; }
	 */
	
	// Recursive method
	/* For getting digit you should call the method with two arguments:
	 * First - is a number
	 * Second - is a position of a digit you want to get (counting starts from the number 1: 
	 * if number is 123 then to get 3rd number you need to call getDigit(123,3)
	 * NB. There's no comparing the position to the real length of a number*/
	private int getDigit(int number, int pos)
	{
		int result = number;
		int length_number = Integer.toString(number).length();
		for (var i=0; i<length_number-pos;i++)
		{
			result = result - getDigit(number, length_number - i)*(int)Math.pow(10,i);		
		}
		
		return result/(int)Math.pow(10,length_number - pos) %10;
	}

	@Test
	void newTest() {
		
	}
}
