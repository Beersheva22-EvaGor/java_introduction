import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	/* NB. Indexing in a method's arguments starts with 0! Therefore the least bit has 0 position */
	@Test
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5; //11101010110_1_11111_1_0101

		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
	}
	
	@Test
	@Disabled
	void setBitValueTest()
	{
		long number = 0x3ab7f5;													//11101010110111111_1_0101
				
		// !In a source code here was a mistake: nBit = 4 (not 5). To check it uncomment next line
		// System.out.println("0x3ab7e5 = "+ Long.toBinaryString(0x3ab7e5));
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));	// 11101010110111111_0_0101
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));		// 1110101011011111_1_00101
		
	}
	
	@Test 
	@Disabled
	void revertBitValueTest()
	{
		long number = 0x3ab7f5; 												//001110101011011111_1_10101
		
		// !In a source code here was a mistake: 0x3ab7d5 instead of 0x3ab7e5. To check it uncomment next line
		// System.out.println("0x3ab7e5 = "+ Long.toBinaryString(0x3ab7e5));  	// 11101010110111111_0_0101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));			//001110101011011111_0_10101
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));			//00111010101101111111010_0
	}
	
	@Test
	@Disabled
	void additionalTest()
	{
		long number = -1;
		
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}
	
	@Test
	void onesInNumberTest()
	{
		assertEquals(64, BitOperations.onesInNumber(-1L));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(1, BitOperations.onesInNumber(32L));
		assertEquals(2, BitOperations.onesInNumber(18L));
	}
	
	@Test 
	void leadingZerosTest()
	{
		assertEquals(0, BitOperations.leadingZeros(-1L));
		assertEquals(64, BitOperations.leadingZeros(0));
		assertEquals(64-6, BitOperations.leadingZeros(32));
		assertEquals(64-4, BitOperations.leadingZeros(12));
	}
	
	@Test
	void isHappyNumberTest()
	{
		assertEquals(false, Numbers.isHappyNumber(123456));
		assertEquals(false, Numbers.isHappyNumber(143456));
		assertEquals(true, Numbers.isHappyNumber(195456));
	}
	
	@Test 
	@Disabled
	void getDigitInNumberTest()
	{
		assertEquals(3, Numbers.getDigitInNumber(123456, 3));
		assertEquals(1, Numbers.getDigitInNumber(123456, 1));
		assertEquals(6, Numbers.getDigitInNumber(123456, 6));
		
		assertEquals(8, Numbers.getNdigits(12345678));
		assertEquals(10, Numbers.getNdigits(1234567890));
	}

}
