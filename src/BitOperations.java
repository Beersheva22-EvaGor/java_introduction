
public class BitOperations {

	/**
	 * right nBit value {0,63]
	 * All methods will return -1 in the case of wrong nBit value
	 */
	
	/**
	 * @param number - any number
	 * @param nBit - number of bit
	 * @return value of bit with number nBit
	 * */
	private static final int N_BITS = 64;
		
	static public int getBitValue(long number, int nBit) 
	{
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			
			res = (number & mask) ==0 ? 0:1;
			/*
			 * if ((number & mask) ==0) { res = 0; } else res = 1;
			 */
		}
		return res;
	}

	private static long getMask(int nBit) {
		long mask = 1L<<nBit; 	// all bits are 0 except bit with number nBit
		return mask;
	}
	
	private static boolean checkNbit(int nBit) {
		
		return nBit<64 && nBit > -1;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @param value - true for 1, false for 0 
	 * @return new number in which value of bit nBit'h bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value)
	{
		long res = -1;
		
		if (checkNbit(nBit))
		{
			long mask = getMask(nBit);
			res = value ? number | mask : number & ~mask;
			
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return new number in which nBit'h will will be inverted
	 */
	static public long invertBitValue(long number, int nBit)
	{
		long res = -1;
		if (checkNbit(nBit))
		{
			long mask = getMask(nBit);
			res = number ^ mask;
		}
		return res;
		//return checkNbit(nBit)? setBitValue(number, nBit, getBitValue(number, nBit)==1 ?false:true):-1;
	}
	
	// quantity 
	static public int leadingZeros(long number)
	{
		int res = 0;
		int nBit = N_BITS -1;
		while ( nBit>=0 && getBitValue(number, nBit) == 0)
		{
			nBit--;
			res++;
		}
		return res;
	}
	
	// the quantity of bytes 1 in a definite number
	static public int onesInNumber(long number)
	{
		int res = 0;
		
		for (int i = 0; i < N_BITS; i++)
		{
			if (getBitValue(number, i) ==1)
			{
				res++;
			}
			// OR:
			//res +=getBitValue(number, i);
		}
		return res;
	}
	

}
