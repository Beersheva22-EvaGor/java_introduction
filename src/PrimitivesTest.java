import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	/*
	 * NB. Indexing in a method's arguments starts with 0! Therefore the least bit
	 * has 0 position
	 */
	@Test
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5; // 11101010110_1_11111_1_0101

		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
	}

	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; // 11101010110111111_1_0101

		// !In a source code here was a mistake: nBit = 4 (not 5). To check it uncomment
		// next line
		// System.out.println("0x3ab7e5 = "+ Long.toBinaryString(0x3ab7e5));
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false)); // 11101010110111111_0_0101
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true)); // 1110101011011111_1_00101

	}

	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101

		// !In a source code here was a mistake: 0x3ab7d5 instead of 0x3ab7e5. To check
		// it uncomment next line
		// System.out.println("0x3ab7e5 = "+ Long.toBinaryString(0x3ab7e5)); //
		// 11101010110111111_0_0101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5)); // 001110101011011111_0_10101
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0)); // 00111010101101111111010_0
	}

	@Test
	@Disabled
	void additionalTest() {
		long number = -1;

		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}

	@Test
	@Disabled
	void onesInNumberTest() {
		assertEquals(64, BitOperations.onesInNumber(-1L));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(1, BitOperations.onesInNumber(32L));
		assertEquals(2, BitOperations.onesInNumber(18L));
	}

	@Test
	@Disabled
	void leadingZerosTest() {
		assertEquals(0, BitOperations.leadingZeros(-1L));
		assertEquals(64, BitOperations.leadingZeros(0));
		assertEquals(64 - 6, BitOperations.leadingZeros(32));
		assertEquals(64 - 4, BitOperations.leadingZeros(12));
	}

	@Test
	@Disabled
	void isHappyNumberTest() {
		assertEquals(false, Numbers.isHappyNumber(123456));
		assertEquals(false, Numbers.isHappyNumber(143456));
		assertEquals(true, Numbers.isHappyNumber(195456));
		assertEquals(false, Numbers.isHappyNumber(010100));
	}

	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = { 1, 2, 3, 4 };
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	@Disabled
	void verifyTest() {
		int id = 346845613; // right case, sum is 40
		assertTrue(IsraelIdentity.verify(id));
		id++;
		assertFalse(IsraelIdentity.verify(id));
		id = 12345678; // only 8 digits
		assertFalse(IsraelIdentity.verify(id));
		id = -123456789; // negative value
		assertFalse(IsraelIdentity.verify(id));
	}

	@Test
	@Disabled
	void generateRandomIdTest() {
		int cycleNum = 10; // number of times to check the randomly created id fits to the claims
		for (int i = 0; i < cycleNum; i++) {
			assertTrue(IsraelIdentity.verify(IsraelIdentity.generateRandomId()));
		}
	}

	@Test
	@Disabled
	void addsNumberTest() {
		int[] array = { 1, 2, 3, 4, 5 };
		int number = 6;
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, MyArrays.addsNumber(array, number));
	}

	@Test
	@Disabled
	void removeNumberTest() {
		// usual case
		int[] array = { 0, 1, 2, 3, 4, 5 };
		int index = 3;
		assertArrayEquals(new int[] { 0, 1, 2, 4, 5 }, MyArrays.removeNumber(array, index));

		// index is out of range
		index = 10;
		assertArrayEquals(array, MyArrays.removeNumber(array, index));
		index = -1;
		assertArrayEquals(array, MyArrays.removeNumber(array, index));

		// first & last indexes
		index = 0;
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, MyArrays.removeNumber(array, index));
		index = array.length - 1;
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, MyArrays.removeNumber(array, index));
	}

	@Test
	@Disabled
	void insertSortedTest() {
		// this number is in the array
		int[] array = { 0, 1, 2, 3, 4, 5 };
		int number = 4;
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 4, 5 }, MyArrays.insertSorted(array, number));

		// there is no number like inserting in the array
		int[] array1 = { 0, 1, 2, 3, 5, 8 };
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 8 }, MyArrays.insertSorted(array1, number));

		// the number is greater than a maximum
		number = 500;
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 500 }, MyArrays.insertSorted(array, number));

		// the number is less than a minimum
		number = -500;
		assertArrayEquals(new int[] { -500, 0, 1, 2, 3, 4, 5 }, MyArrays.insertSorted(array, number));
	}

	@Test
	void binarySearchFirstTest() {
		int myarray[] = { 0, 0, 0, 1, 2, 3, 3, 3, 4, 5, 5 };
		assertEquals(5, MyArrays.binarySearchFirst(myarray, 3)); // middle placed
		assertEquals(0, MyArrays.binarySearchFirst(myarray, 0)); // left edge
		assertEquals(9, MyArrays.binarySearchFirst(myarray, 5)); // right edge
		assertEquals(-1, MyArrays.binarySearchFirst(myarray, 500)); // no number inside
	}

	@Test
	void oneReplaceNeededTest() {
		assertTrue(MyArrays.oneReplaceNeeded(new int[] { 0, 1, 5, 2, 3, 4, 6, 7 })); // only one replacing in middle
		assertTrue(MyArrays.oneReplaceNeeded(new int[] { 5, 0, 1, 2, 3, 4, 6, 7 })); // only one replacing at the
																						// beginning
		assertTrue(MyArrays.oneReplaceNeeded(new int[] { 0, 1, 2, 3, 4, 6, 7, 5 })); // only one replacing at the end
		assertFalse(MyArrays.oneReplaceNeeded(new int[] { 0, 5, 2, 6, 1, 7, 4, 3 })); // >1 replacing needed
		assertFalse(MyArrays.oneReplaceNeeded(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 })); // sorted, no need replacing
		assertFalse(MyArrays.oneReplaceNeeded(new int[] { 0, 1, 2, 3, 3, 4, 5, 6 })); // double number, no need replacing
	}

	@Test
	void binarySearchInt() {
		int arraySorted[] = {0, 3, 6, 8, 10, 12};
		assertEquals(Arrays.binarySearch(arraySorted, 0), MyArrays.binarySearchInt(arraySorted, 0)); // 1st numbers in array, inside
		assertEquals(Arrays.binarySearch(arraySorted, 8), MyArrays.binarySearchInt(arraySorted, 8)); // in the middle of array, inside
		assertEquals(Arrays.binarySearch(arraySorted, 12), MyArrays.binarySearchInt(arraySorted, 12)); // last numbers in array, inside
		assertEquals(Arrays.binarySearch(arraySorted, -5), MyArrays.binarySearchInt(arraySorted, -5)); // out of range - left
		assertEquals(Arrays.binarySearch(arraySorted, 100), MyArrays.binarySearchInt(arraySorted, 100)); // out of range - right	
		assertEquals(Arrays.binarySearch(arraySorted, 4), MyArrays.binarySearchInt(arraySorted, 4)); // in range, but doesn't belong (center)
		assertEquals(Arrays.binarySearch(arraySorted, 2), MyArrays.binarySearchInt(arraySorted, 2)); // in range, but doesn't belong (beginning)
		
	}
	
	@Test
	void arrayBubbleSorterTest() {
		int arrayUnsorted[] = {0, 3, -1, -2, 6, 8, 13, 10, 15, 2, 3, 12};
		int [] copyArray = Arrays.copyOf(arrayUnsorted, arrayUnsorted.length);
		int iter = MyArrays.arrayBubbleSorter(copyArray);
		Arrays.sort(arrayUnsorted);
		assertArrayEquals(arrayUnsorted, copyArray); 				// partly sorted 
		System.out.println("Middle case - partly sorted. Number of iterations: " +iter);
		
		System.out.println("Best case - fully sorted. Number of iterations: " +MyArrays.arrayBubbleSorter(arrayUnsorted));
		
		int arrayFullyUnsorted[] = {50, 30, 10, 2, 0, -3, -7 , -9};
		copyArray = Arrays.copyOf(arrayFullyUnsorted, arrayFullyUnsorted.length);
		iter = MyArrays.arrayBubbleSorter(copyArray);
		System.out.println("Worst case - fully unsorted. Number of iterations: " +iter);
		Arrays.sort(arrayFullyUnsorted);
		assertArrayEquals(arrayFullyUnsorted, copyArray);				// worst case - fully unsorted
		
		
		
	}
}
