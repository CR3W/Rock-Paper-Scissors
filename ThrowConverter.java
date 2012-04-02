package rockpaperscissors;

/**
 * Provides static methods for throw conversion between <tt>String</tt> 
 * representation, respective <tt>char</tt> representation and respective 
 * <tt>int</tt> representation. 
 * @author  CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class ThrowConverter 
{
	/**
	 * Converts throw from <tt>int</tt> to <tt>char</tt>
	 * @param throwSelection <tt>int</tt> form of the throw  
	 * @return <tt>char</tt> form of the throw
	 */
	public static char convertToChar(int throwSelection)
	{
		return Match.throwChoices.charAt(throwSelection);
	}
	
	/**
	 * Converts throw from <tt>char</tt> to <tt>int</tt>
	 * @param throwSelection <tt>char</tt> form of the throw
	 * @return <tt>int</tt> form of the throw
	 */
	public static int convertToInt(char throwSelection)
	{
		switch(throwSelection)
		{
			case 'R':return Match.ROCK;
			case 'P':return Match.PAPER;
			case 'S':return Match.SCISSORS;
			default: return 0;
		}
	}
	
	/**
	 * Converts throw from <tt>int</tt> to <tt>String</tt>
	 * @param throwSelection <tt>int</tt> from of the throw
	 * @return <tt>String</tt> form of the throw
	 */
	public static String convertToString(int throwSelection)
	{
		switch(throwSelection)
		{
			case Match.ROCK: return "Rock";
			case Match.PAPER: return "Paper";
			case Match.SCISSORS: return "Scissors";
			default: return null;
		}
	}
	
	/**
	 * Converts throw from <tt>char</tt> to <tt>String</tt>
	 * @param throwSelection <tt>char</tt> form of the throw
	 * @return <tt>String</tt> form of the throw
	 */
	public static String convertToString(char throwSelection)
	{
		switch(throwSelection)
		{
			case 'R': return "Rock";
			case 'P': return "Paper";
			case 'S': return "Scissors";
			default: return null;
		}
	}
}
