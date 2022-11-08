
public class IsraelIdentity {

	private static final int N_DIGITS = 9;

	/**
	 * 
	 * @param id
	 * @return true for right id. Otherwise - false
	 * 
	 *         number must contain 9 digits control sum should be multiple of 10
	 *         (sum % 10 == 0) for even indexes (0,2,4,6,8) digits as is for odd
	 *         indexes (1,3,5,7) digit = digit *2, if > 9 - the sum of inner digits
	 *         is taken
	 * 
	 *         ex. 123456782 => 1 + 4<2*2> + 3 + 8 <4*2> + 5 + 3 <6*2=12 -> 1+2=3> +
	 *         7 +7 <8*2 = 16 -> 1+6 =7> +2 = 40 % 10 = 0 so the id above is right
	 */
	public static boolean verify(int id) {
		int sum = -1;
		if (Numbers.getNdigits(id) == N_DIGITS && id > 0) {
			sum = controlSum(Numbers.getDigits(id));
		}
		return sum % 10 == 0;
	}

	private static int controlSum(int[] digitArray) {
		int sum = 0;
		for (int even = 0; even < N_DIGITS; even += 2) {
			sum += digitArray[even];
		}

		for (int odd = 1; odd < N_DIGITS; odd += 2) {
			int doubleOdd = 2 * digitArray[odd];
			if (Numbers.getNdigits(doubleOdd) > 1) {
				sum += Numbers.getSumDigits(doubleOdd);
			} else
				sum += doubleOdd;
		}
		return sum;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id
	 * 
	 *         cycle must contain less than 10 iterations! (<=9 iterations) 0 is a
	 *         possible digit but not the very 1st one
	 * 
	 *         NB! The code hereafter works well with only odd length of id. For now
	 *         there's no need to extend code due to the assumption the number of
	 *         digits in id won't change. But if it happens one of the decision
	 *         could be passing the role of make the id satisfied the control sum to
	 *         the element with the last even index
	 */
	public static int generateRandomId() {
		int idArray[] = new int[N_DIGITS];

		// fill the array with random digits except last element
		idArray[0] = SportlotoApp.getRandom(1, 9);
		for (int i = 1; i < N_DIGITS - 1; i++) {
			idArray[i] = SportlotoApp.getRandom(0, 9);
		}

		// define last element: if array already suits for claims write 0 to array
		int ctrlSumOk = controlSum(idArray) % 10;
		idArray[N_DIGITS - 1] = ctrlSumOk == 0 ? 0 : 10 - ctrlSumOk;

		return Numbers.getNumberFromDigits(idArray);
	}
}
