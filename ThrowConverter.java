package rockpaperscissors;

public class ThrowConverter 
{
	public static int convertThrowToInt(char throwSelection)
	{
		switch(throwSelection)
		{
			case 'R':return Match.ROCK;
			case 'P':return Match.PAPER;
			case 'S':return Match.SCISSORS;
			default: return 0;
		}
	}
	
	public static char convertThrowToChar(int throwSelection)
	{
		return Match.throwChoices.charAt(throwSelection);
	}
	
	public static String convertThrowToString(int throwSelection)
	{
		switch(throwSelection)
		{
			case Match.ROCK: return "Rock";
			case Match.PAPER: return "Paper";
			case Match.SCISSORS: return "Scissors";
			default: return null;
		}
	}
	
	public static String convertThrowToString(char throwSelection)
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
