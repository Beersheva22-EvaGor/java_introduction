import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MatricesTest {

	@Test
	void transpTest() {
		int[][] matrix = { 
				{ 1, 2 }, 
				{ 3, 4 }, 
				{ 4, 5 } 
				};
		int[][] expected = { 
				{ 1, 3, 4 }, 
				{ 2, 4, 5 } 
				};
		
		assertArrayEquals(expected, Matrices.transp(matrix));
	}
	
	@Test
	void isSum2Test()
	{
		short[] array = {1, 22, 3, 17, 0, 18, 4};
		
		assertTrue(MyArrays.isSum2(array, (short)5)); // on corners
		assertTrue(MyArrays.isSum2(array, (short)40)); // middle
		assertTrue(MyArrays.isSum2(array, (short)17)); // with 0 
		
		assertFalse(MyArrays.isSum2(array,(short) 0));
		assertFalse(MyArrays.isSum2(array,(short) 16));
		
		array = new short[]{1, 22, 3, 3, 17, 17, 18, 0, 4};
		assertTrue(MyArrays.isSum2(array, (short)20)); // middle
		assertTrue(MyArrays.isSum2(array, (short)34)); // repeated numbers
		
		assertFalse(MyArrays.isSum2(array,(short) 100));
		
		assertFalse(MyArrays.isSum2(array,(short) -100));
	}

}
