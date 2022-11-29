package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";
	private static final int COUNT_NUMBERS = 10;
	private static String[][] DISPLAY_NUMBERS ;

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		String[] res = new String[height];
		DISPLAY_NUMBERS = new String[COUNT_NUMBERS][];
		java.util.Arrays.fill(res,"");
		
		int[] digits = getDigits(number);
		for (int i = 0; i < digits.length; i++) {
			res = attendDigit(offset, width, height,  res, DISPLAY_NUMBERS, digits, i);
		}		
		displayStrings(res);
	}


	private static String[] attendDigit(int offset, int width, int height, String[] res, String[][] displayNumbers, int[] digits, int i) {
		for (var j = 0; j < res.length; j++) {
			if (displayNumbers[digits[i]]==null) {
				switch (digits[i]) {
				case 0: displayNumbers[digits[i]] = zero(offset, width, height); break;
				case 1: displayNumbers[digits[i]] = one(offset, width, height); break;
				case 2: displayNumbers[digits[i]] = two(offset, width, height); break;
				case 3: displayNumbers[digits[i]] = three(offset, width, height); break;
				case 4: displayNumbers[digits[i]] = four(offset, width, height); break;
				case 5: displayNumbers[digits[i]] = five(offset, width, height); break;
				case 6: displayNumbers[digits[i]] = six(offset, width, height); break;
				case 7: displayNumbers[digits[i]] = seven(offset, width, height); break;
				case 8: displayNumbers[digits[i]] = eight(offset, width, height); break;
				case 9: displayNumbers[digits[i]] = nine(offset, width, height); break;
				}					 
			}
			res[j]+= displayNumbers[digits[i]][j];
			// add spaces to row digits
			String spaces = " ".repeat((i+1)*(width+offset) - res[j].length());
			res[j]+=spaces;
		}
		return res;
	}


	private static int[] getDigits(int number) {
		int res[] = new int[Integer.toString(number).length()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static void displayStrings(String[] strings) {
		if (strings != null) {
			for (int i = 0; i < strings.length; i++) {
				if (strings[i] != null) {
					System.out.println(strings[i]);
				} else {
					System.out.println("");
				}

			}
		}
	}
	// numbers realization

	public static String[] zero(int offset, int width, int height) {
		return constructor(offset, width, height, true, true, true, false, true, true, true);
	}

	public static String[] one(int offset, int width, int height) {
		return constructor(offset, width, height, false, false, true, false, false, true, false);
	}

	public static String[] two(int offset, int width, int height) {
		return constructor(offset, width, height, true, false, true, true, true, false, true);
	}

	public static String[] three(int offset, int width, int height) {
		return constructor(offset, width, height, true, false, true, true, false, true, true);
	}

	public static String[] four(int offset, int width, int height) {
		return constructor(offset, width, height, false, true, true, true, false, true, false);
	}

	public static String[] five(int offset, int width, int height) {
		return constructor(offset, width, height, true, true, false, true, false, true, true);
	}

	public static String[] six(int offset, int width, int height) {
		return constructor(offset, width, height, true, true, false, true, true, true, true);
	}

	public static String[] seven(int offset, int width, int height) {
		return constructor(offset, width, height, true, false, true, false, false, true, false);
	}

	public static String[] eight(int offset, int width, int height) {
		return constructor(offset, width, height, true, true, true, true, true, true, true);
	}

	public static String[] nine(int offset, int width, int height) {
		return constructor(offset, width, height, true, true, true, true, false, true, true);
	}

	/**
	 * 
	 * @param offset 
	 * @param width
	 * @param height
	 * @param top	true if top line is necessary
	 * @param topleft	true if upper left line is necessary
	 * @param topright	true if upper right line is necessary
	 * @param center	true if center line is necessary
	 * @param bottomleft	true if bottom left line is necessary
	 * @param bottomright	true if bottom right line is necessary
	 * @param bottom	true if bottom line is necessary
	 * @return	array with rows of strings with lines of SYMBOL's representations
	 */
	private static String[] constructor(int offset, int width, int height, boolean top, boolean topleft,
			boolean topright, boolean center, boolean bottomleft, boolean bottomright, boolean bottom) {
		String[] res = new String[height];
		if (height > 0) {
			if (height > 0) {
				int centerPosition = height % 2 == 0 ? (height - 1) / 2 : height / 2;
				if (topleft && topright) {
					res = bothLines(offset, width, height, res, centerPosition, 0);					
				} else if (topleft) {
					res = topOneLine( offset, res, centerPosition);
				} else if (topright) {
					res = topOneLine( offset + width - 1, res, centerPosition);
				}
				if (bottomleft && bottomright) {
					res = bothLines(offset, width, height, res, centerPosition, centerPosition);
				} else if (bottomleft) {
					res = bottomOneLine(offset, height, res, centerPosition);
				} else if (bottomright) {
					res = bottomOneLine(offset + width - 1, height, res, centerPosition);
				}
				if (center) {
					res[centerPosition] = line(offset, width);
				}
			}
			if (top) {
				res[0] = line(offset, width);
			}
			if (bottom) {
				res[height - 1] = line(offset, width);
			}
		}
		return res;
	}

	private static String[] bottomOneLine(int startpoint, int height, String[] res, int centerPosition) {
		String[] bottomRPosition = verticalLine(startpoint, height - centerPosition);
		System.arraycopy(bottomRPosition, 0, res, centerPosition, bottomRPosition.length);
		return res;
	}	

	private static String[] topOneLine(int startpoint, String[] res, int centerPosition) {
		String[] topRPosition = verticalLine(startpoint, centerPosition);
		System.arraycopy(topRPosition, 0, res, 0, topRPosition.length);
		return res;
	}
	
	private static String[] bothLines(int offset, int width, int height, String[] res, int centerPosition, int startIndex) {
		String[] bottomLRPosition = twoVerticalLines(offset, width, height - centerPosition);
		System.arraycopy(bottomLRPosition, 0, res, startIndex, bottomLRPosition.length);
		return res;
	}

}
