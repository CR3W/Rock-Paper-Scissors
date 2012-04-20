package rockpaperscissors;

import rockpaperscissors.Exceptions.InvalidCommandException;

/**
* Analyzes the given input to determine what actions should be taken with it.
* @author CR3W
* @version Object-Oriented Design (CS 151)
*/
public class InputAnalyzer
{
public static final int COMMAND_INPUT = 1558;//Used if user inputs command during a match
    private RockPaperScissorsGame mainGame;//Used to access methods for displaying help & score
    
    public InputAnalyzer(RockPaperScissorsGame rpsg)
    {
        mainGame = rpsg;
    }
    
    /**
* Determines the users throw for the match in the RPS game. If the input is not a valid throw
* It will be check to see if the input is a valid command. If the command is valid, the command
* will be executed.
* @param rawInput some input
* @return Throw constant representing User's throw or <B>COMMAND_INPUT</B> constant, signifying
* that the user has called a successful command.
* @exception InvalidCommandException User has not input a valid command.
*/
    public int determineThrow(String rawInput) throws InvalidCommandException
    {
        if(rawInput.length() > 1)
            throw new InvalidCommandException();
        
        char input = rawInput.charAt(0);
        switch(input)
        {
            case 'R': return Match.ROCK;
            case 'P': return Match.PAPER;
            case 'S': return Match.SCISSORS;
            case 'F': mainGame.displayFeatures();return COMMAND_INPUT;
            case 'H': mainGame.displayFeatures();return COMMAND_INPUT;
            case 'D': mainGame.displayScore();return COMMAND_INPUT;
            default: throw new InvalidCommandException();
        }
    }
    
    /**
* <B>Deprecated method, only kept for reference</B>
* Determines what action should be taken base on the given input
* <B>No longer attempts to start match. Match starting is now handled in the Main Game.
* Kept for reference.</B>
* @param rawInput some input
* @deprecated No longer needed since user does not explicitly start the match. It is started automattically.
*/
    public void determineAction(String rawInput)throws InvalidCommandException
    {
        //If input is not a number, and input is greater than length one, we know input to
        //invalid because all commands are 1 character long.
        if(rawInput.length() > 1)
            throw new InvalidCommandException();
        
        char input = rawInput.charAt(0);
        
        //Checks to see if input matches any of the commands.
        switch(input)
        {
            case('F'):mainGame.displayFeatures();break;
            case('H'):mainGame.displayFeatures();break;
            case('D'):mainGame.displayScore();break;
        }
    }
}