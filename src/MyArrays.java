import java.util.Arrays;

public class MyArrays {

	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array that consists of all the elements of the array in an input
	 *         argument with added a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] resArray = Arrays.copyOf(array, array.length + 1);
		resArray[resArray.length - 1] = number;
		return resArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * 
	 *         if index does not exist in a given array it return the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		int[] dest;
		if (index > -1 && index < array.length) {
			dest = new int[array.length - 1];
			System.arraycopy(array, 0, dest, 0, index);
			if (index < array.length - 1)
				System.arraycopy(array, index + 1, dest, index, array.length - index - 1);
		} else
			dest = array;
		return dest;
	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		int[] resArray = new int[arraySorted.length + 1];
		int binarySearchResult = Arrays.binarySearch(arraySorted, number);

		if (binarySearchResult > 0) {
			resArray = insertNumber(arraySorted, number, binarySearchResult);
		} else {
			resArray = insertNumber(arraySorted, number, -(binarySearchResult + 1));
		}
		return resArray;
	}

	/**
	 * Additional method
	 * 
	 * @param array
	 * @param number
	 * @param index
	 * @return the new array with inserted number on the index - position
	 * 
	 *         if index out of possible range it returns the initial array
	 */
	private static int[] insertNumber(int[] array, int number, int index) {
		int[] dest;
		if (index > -1 && index < array.length) {
			dest = new int[array.length + 1];
			System.arraycopy(array, 0, dest, 0, index);
			dest[index] = number;
			System.arraycopy(array, index, dest, index + 1, array.length - index);
		} else if (index == array.length) {
			dest = addsNumber(array, number);
		} else
			dest = array;

		return dest;
	}

}
