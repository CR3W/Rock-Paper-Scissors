package rockpaperscissors;

import rockpaperscissors.Exceptions.InvalidCommandException;
import rockpaperscissors.Exceptions.InvalidInputException;
import rockpaperscissors.ThrowGenerators.*;

/**
 * Rock Paper Scissors Game with machine learning. The A.I. in the game
 * will attempt to learn patterns from the user playing in order to
 * try and predict the users throw of rock, paper or scissors. 
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class RockPaperScissorsGame 
{
	Match match;//Handles match information
    Input input;//Handles inputs and filters out bad input
    Score score;//Handles score information
    ThrowRecorder recorder;//Records throws made by the user and computer
    InputAnalyzer analyzer;//Analyzes input and determines what to do with it
    
    /**
     * Constructs RockPaperScissorsGame
     * @param matchLength length of the match
     * @param throwGeneratorType ('S' or 'R') Type of A.I. used by the computer
     * to generate throws (Smart or Random)
     */
    public RockPaperScissorsGame(int matchLength, char throwGeneratorType)
    {
        input = new Input();
        score = new Score();
        recorder = new ThrowRecorder();
        analyzer = new InputAnalyzer(this);
        runGame(matchLength, throwGeneratorType);
    }
    
    /**
     * Starts a match of the given length using the specified Throw Generator
     * @param matchLength desired length of the match
     * @param generator Type of Throw Generator used to generate a throw
     */
    public void startMatch(int matchLength, ThrowGenerator generator)
    {
    	/*Begin match set up*/
    	match = new Match(matchLength);//Creates a match of n length
    	
    	String rawInput = null;//Used to get input from user
    	String userThrow = null;//Used for display purposes
    	String computerThrow = null;//Used for display purposes
    	int computerSelection = -1;//int representation of throw
    	int userSelection = -1;//int representation of throw
    	char outcome = ' ';//determines comparison outcome
    	/*End match set up*/
    	
    	System.out.printf("Match of %d length has begun.\n",matchLength);
    	System.out.printf("Note: At any time you can enter (F)/(H) for help\n");
        while(match.isNotOver())
        {
        	System.out.print("Select a throw (R) Rock (P) Paper (S) Scissors: ");
        	try 
        	{
        		//Gets throw/command from user
				rawInput = input.getInput();
        		//Determines the users throw
        		userSelection = analyzer.determineThrow(rawInput);
			} 
        	catch (InvalidInputException e) 
        	{
        		//Invalid input, re-prompts user form throw/command
        		System.out.println("Invalid input. Please re-enter:");
        		match.invalidateRound();
        		continue;
			}
        	catch(InvalidCommandException e)
        	{
        		//Invalid command/throw entered.
        		System.out.println("No such command. Please re-enter:");
        		match.invalidateRound();
        		continue;
        	}
        	
        	//User entered input that was a command.
        	if(userSelection == InputAnalyzer.COMMAND_INPUT)
        	{	match.invalidateRound();continue;}
        	
        	//At this point user has passed all special cases and has made a throw
        	//computers throw is then determined.
        	computerSelection = generator.generateThrow();
        	//Converts the user and computer throws to characters and then records them
        	recorder.recordThrows(ThrowConverter.convertToChar(userSelection), 
        					      ThrowConverter.convertToChar(computerSelection));
        	
        	//Compares the player/computer's throw selection. Determines and displays a winner
        	outcome = match.compare(userSelection, computerSelection);
        	
        	//Converts throws to strings for display purposes
            userThrow = ThrowConverter.convertToString(userSelection);
        	computerThrow = ThrowConverter.convertToString(computerSelection);
        	switch(outcome)
        	{
	        	case 'W': System.out.printf("You Won! :) [You: %s |Computer: %s]\n",userThrow,computerThrow);break;
	        	case 'L': System.out.printf("You Lost! :( [You: %s |Computer: %s]\n",userThrow,computerThrow);break;
	        	case 'T': System.out.printf("You Tied! :| [You: %s |Computer: %s]\n",userThrow,computerThrow);break;
        	}
        }
    }
    
    /**
     * Displays information about the game
     */
    public void displayFeatures()
    {
        System.out.println(Features.getFeaturesInformation());
    }
    
    /**
     * Displays the current scores
     */
    public void displayScore()
    {
        System.out.println(score.getScores());
    }
    
    /**
     * Method used to run the Rock Paper Scissors game.
     * @param matchLength length of each match
     * @param throwType type of Throw Generator ('S' Smart|'R' Random)
     */
    public void runGame(int matchLength, char throwType)
    {   
    	ThrowGenerator throwGenerator = null;
    	
    	//Determines which A.I. to use
        switch(throwType)
        {
            case'S':
            	System.out.println("Game mode SMART selected");
            	throwGenerator = new SmartThrow(recorder);
            	break;
            case'R':
            	System.out.println("Game mode RANDOM selected");
            	throwGenerator = new RandomThrow();
            	break;
            default:
            	System.out.println("Bad command line parameter given" 
            			        + "SMART selected by default");           	
            	throwGenerator = new SmartThrow(recorder);
            	break;
        }
        
        startMatch(matchLength, throwGenerator);
        System.out.println("Have a good day! Hope you play again soon!");
    }
    
    public static void main(String[] args)
    {
    	int matchLength = Integer.parseInt(args[0]);//Gets match length
    	char throwType = args[1].toUpperCase().charAt(0);//Gets throw type
        RockPaperScissorsGame rpsGame = new RockPaperScissorsGame(matchLength, throwType);

    }
}
