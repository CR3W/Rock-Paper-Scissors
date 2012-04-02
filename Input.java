package rockpaperscissors;

import java.util.Scanner;

import rockpaperscissors.Exceptions.InvalidInputException;

/**
 * Class to retrieve and validate input from a console
 * @author  CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class Input 
{
    private Scanner scanner; //Scanner object for getting input
    private String validCharacters = "abcdefghijklmnopqrstuvwxyz"
                                   + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                   + "0123456789";//Valid characters
    /**
     * Constructs a new Input object
     */
    public Input()
    {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Method to get input from a console
     * @return String if input is valid.
     * @exception Input is invalid (Invalid characters are used)
     */
    public String getInput() throws InvalidInputException
    {
        String input = scanner.nextLine();
        input = input.toUpperCase();
        if(validateInput(input))
            return input;
        
        throw new InvalidInputException();
    }
    
    /**
     * Validates user input from a console
     * @param input String to be validated
     * @return true if valid. False if invalid
     */
    private boolean validateInput(String input)
    {
        for(int i=0;i<input.length();i++)
            if(validCharacters.indexOf(input.charAt(i))==-1)
                return false;
        
        return true;
    }
}
