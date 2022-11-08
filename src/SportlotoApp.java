//import java.security.DigestInputStream;


public class SportlotoApp {
	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusively
	 * Numbers cannot be repeated in one sequence of 6 numbers
	 * no additional collections arrays
	 */
	
	// PRE-DEFINES
	private static final int digitsInNumber = 6;
	private static final int minNumber = 1;
	private static final int maxNumber = 49;
	
	/* Global variable that stores all 1 in a binary code at the very beginning 
	* and changes bites to 0 if this variable was used
	* NB. Only for numbers less than 64
	*/
	private static long container = -1L; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i<digitsInNumber; i++)
		{
			System.out.print(getRandomInt(minNumber, maxNumber)+" ");
			
		}

	}
	
	public static int getRandom(int min, int max)
	{
		return min + (int)Math.round(Math.random()*(max - min));
	}
	
	public static int getRandomInt(int min, int max)
	{			
		int res;
		do
		{
			res = getRandom(min, max);
		}
		while (BitOperations.getBitValue(container, res-1) == 0);
		container = BitOperations.invertBitValue(container, res-1);
		return res;
	}

}
