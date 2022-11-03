
public class Numbers {

	// PRE-DEFINES
	static private final int nDigits = 6;
	
	static public int getNdigits(long number)
	{
		int res = 0;
		
		do 
		{
			number /= 10;
			res++;
		}
		while (number != 0);
		return res;
	}
	
	/**
	 * 
	 * @param number
	 * @param position starts from 1
	 * @return the digit in a number on the defined in arguments position
	 */
	static public int getDigitInNumber(int number, int position)
	{
		int res = -1;
		//TODO Check position must be less than number length
		res = (int)(number / Math.pow(10, getNdigits(number)-position)) %10;
		return res;
	}
	
	/**
	 * 
	 * @param number
	 * @return true only if number comprises of 6 digits
	 * and sum of the first three digits is equal to the sum if the last three digits
	 */
	static public boolean isHappyNumber (int number)
	{
		int oper = -1;					// sum of left and right parts of a number
		int length = getNdigits(number);
		if (length==nDigits)			// check the number has 6 digits
		{
			// in a result sum of first three digits minus sum of right 3 digits must be 0
			oper=0;			
			for (int i = 1; i<=length; i++ )
			{
				oper = i<=3? oper + getDigitInNumber(number, i) : oper - getDigitInNumber(number, i);
			}
			
		}
		
		return oper == 0;
	}
}
