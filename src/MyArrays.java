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
			// if (index < array.length - 1)
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
		int index = Arrays.binarySearch(arraySorted, number);

		if (index < 0) {
			index = -(index + 1);
		}

		return insertAtIndex(arraySorted, number, index);
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
	private static int[] insertAtIndex(int[] array, int number, int index) {
		int[] dest = new int[array.length + 1];
		System.arraycopy(array, 0, dest, 0, index);
		dest[index] = number;
		System.arraycopy(array, index, dest, index + 1, array.length - index);

		return dest;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists or -1 O[N] - search number in unsorted
	 *         array O[LogN] - search number in sorted (binary search)
	 */
	private static int left_global = 0;
	private static int right_global = 0;

	public static int binarySearch(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		left_global = left;
		right_global = right;
		return left > right ? -1 : middle;

	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return first index of aiming number
	 */
	public static int binarySearchFirst(int arraySorted[], int number) {
		int res = binarySearch(arraySorted, number);
		if (res > -1) {
			res = searchLeft(Arrays.copyOf(arraySorted, res + 1));
		}
		return res;
	}

	private static int searchLeft(int[] arraySorted) {
		int aim = arraySorted[arraySorted.length - 1];
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left != right) {
			if (arraySorted[middle] == aim) {
				right = middle;
			} else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
		return right;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return analog of Arrays.binarySearch implemented by global variables of the
	 *         realized above method
	 */
	public static int binarySearchInt(int[] arraySorted, int number) {

		int res = binarySearch(arraySorted, number);
		if (res == -1 && left_global > right_global) {
			res = -(left_global + 1);
		}
		return res;
	}

	/**
	 * 
	 * @param array
	 * @return true if only one replace is needed to the array be sorted
	 */
	public static boolean oneReplaceNeeded(int[] array) {
		int unsorted = 0;
		if (array.length > 1) {
			int i = 0;
			do {
				if (array[i] > array[i + 1]) {
					unsorted++;
				}
				i++;
			} while (unsorted < 2 && i < array.length - 1);
		}
		return unsorted == 1;
	}

	/**
	 * This bubble method uses an idea of going out of the cycle if there was no
	 * replacing on the previous cycle (array is always sorted) and combined with
	 * the idea of sending minimal element on every iteration to the left corner of
	 * current span (therefore left edge of the sorting span moves right on every
	 * iteration)
	 * 
	 * Initial array is sorted after the method finishes
	 * 
	 * @param arrayUnsorted
	 * @return number of cycles needed to sort
	 */
	public static int arrayBubbleSorter(int[] arrayUnsorted) {
		int cycleNum = 0; // number of the cycle (some elements are sorted on each cycle)
		int temp = 0; // temporary variable to store elements'values
		int left = 0; // index of the left edge of span
		int replaceNum = arrayUnsorted.length; // if on the previous cycle there wasn't replacing the array is always
												// sorted - no need to sort more
		while (cycleNum < arrayUnsorted.length - 1 && replaceNum > 0) {
			replaceNum = 0;
			for (int i = left; i < arrayUnsorted.length - 1 - cycleNum; i++) {
				if (arrayUnsorted[i] > arrayUnsorted[i + 1]) {
					temp = arrayUnsorted[i + 1];
					arrayUnsorted[i + 1] = arrayUnsorted[i];
					arrayUnsorted[i] = temp;

					replaceNum++;
				}
				// checking the minimum value on every iteration
				if (arrayUnsorted[left] > arrayUnsorted[i]) {
					temp = arrayUnsorted[left];
					arrayUnsorted[left] = arrayUnsorted[i];
					arrayUnsorted[i] = temp;
				}

			}
			left++;
			cycleNum++;
		}
		return cycleNum;
	}


}
