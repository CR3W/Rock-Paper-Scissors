package rockpaperscissors;

/**
 *
 * @author Eric
 */
public class NotEnoughDataException extends Exception
{
    public NotEnoughDataException()
    {
        super();
    }
    
    public NotEnoughDataException(String message)
    {
        super(message);
    }
}