package rockpaperscissors.Exceptions;

/**
 * Exception used when the user has attempted to call an invalid command.
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class InvalidCommandException extends Exception
{
	/**
	 * Constructs a new InvalidCommandException with null as its detail message
	 */
	public InvalidCommandException()
	{
		super();
	}
	
	/**	 
	 * Constructs a new exception with the specified detail message.
	 * @param message the detail message.
	 */
	public InvalidCommandException(String message)
	{
		super(message);
	}
}
