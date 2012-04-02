package rockpaperscissors.Exceptions;

/**
 * Exception used when the user has made invalid input
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class InvalidInputException extends Exception
{
	/**
	 * Constructs a new exception with null as its detail message.
	 */
    public InvalidInputException()
    {
        super();
    }
    
    /**
     * Constructs a new exception with specified detail message.
     * @param message the detail message
     */
    public InvalidInputException(String message)
    {
        super(message);
    }
}
