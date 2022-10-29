
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
	static public int getBitValue(long number, int nBit) 
	{
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = 1<<nBit; 	// all bits are 0 except bit with number nBit
			if ((number & mask) ==0) {
				res = 0;
			}
			else res = 1;
		}
		return res;
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
			if (getBitValue(number, nBit) == (value? 1:0))
			{ 
				// no need to change anything
				res = number;
			}
			else
			{
				res = number;			
				long mask;
				if (!value) 
				{
					mask = ~(1<< nBit); 				
					res = number & mask;
				}
				else
				{
					mask = ~(1<<nBit);
					res = ~(number ^ mask);
				}			
			
			}
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return new number in which nBit'h will will be reverted
	 */
	static public long revertValue(long number, int nBit)
	{
		return checkNbit(nBit)? setBitValue(number, nBit, getBitValue(number, nBit)==1 ?false:true):-1;
	}
}
