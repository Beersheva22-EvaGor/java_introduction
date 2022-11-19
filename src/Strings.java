
public class Strings {

	static int asciiSize = 128;

	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if anagram (str2) can be received from str1 by replacing letters
	 *         O[N] str2 must contains all symbols of str1 uses 1! additional array
	 *         of char + 1. the same length + 2. the same symbols
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			res = true;
			int[] ascii = new int[asciiSize];
			char[] str1Arr = str1.toCharArray();
			char[] str2Arr = str2.toCharArray();
			for (int i = 0; i < str1.length(); i++) {
				// for 1st string
				int index1 = (int) str1Arr[i];
				ascii[index1]++;

				// for 2st string
				int index2 = (int) str2Arr[i];
				ascii[index2]--;
			}
			int i = 0;
			while (res && i < ascii.length) {
				if (ascii[i] != 0)
					res = false;
				i++;
			}
		}
		return res;
	}
	
	public static void sortStringNumbers(String[] strNumArr) {
		int[] indexes = new int[Byte.MAX_VALUE - Byte.MIN_VALUE + 1];		
		for (var i =0; i< strNumArr.length; i++) {
			indexes[Integer.parseInt(strNumArr[i]) - Byte.MIN_VALUE] ++;
		}
		int j = 0;
		for (int i = 0; i< indexes.length; i++) {
			for (int l =0; l<indexes[i]; l++){				
				strNumArr[j] =  Integer.toString(i + Byte.MIN_VALUE);
				j++;
			}
		}
	}
}
