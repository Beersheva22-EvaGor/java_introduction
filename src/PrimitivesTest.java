import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	/* NB. Indexing in a method's arguments starts with 0! Therefore the least bit has 0 position */
	@Test
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
	void setBitValueTest()
	{
		long number = 0x3ab7f5;													//11101010110111111_1_0101
				
		// !In a source code here was a mistake: nBit = 4 (not 5). To check it uncomment next line
		// System.out.println("0x3ab7e5 = "+ Long.toBinaryString(0x3ab7e5));
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));	// 11101010110111111_0_0101
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));		// 1110101011011111_1_00101
		
	}
	
	@Test 
	void revertBitValueTest()
	{
		long number = 0x3ab7f5; 												//001110101011011111_1_10101
		
		// !In a source code here was a mistake: 0x3ab7d5 instead of 0x3ab7e5. To check it uncomment next line
		// System.out.println("0x3ab7e5 = "+ Long.toBinaryString(0x3ab7e5));  	// 11101010110111111_0_0101
		assertEquals(0x3ab7d5, BitOperations.revertValue(number, 5));			//001110101011011111_0_10101
		assertEquals(0x3ab7f4, BitOperations.revertValue(number, 0));			//00111010101101111111010_0
	}
}
