package rockpaperscissors;

/**
 * Rock Paper Scissors Game
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class RockPaperScissorsGame 
{
	Match match;
    Input input;
    Score score;
    ThrowRecorder recorder;
    InputAnalyzer analyzer;
    
    /**
     * Standard constructor used to build RockPaperScissorGame object
     */
    public RockPaperScissorsGame()
    {
        input = new Input();
        score = new Score();
        recorder = new ThrowRecorder();
        analyzer = new InputAnalyzer(this);
    }
    
    /**
     * Starts a match of the given length
     * @param matchLength desired length of the match
     * @deprecated use startMatch(int matchLength, ThrowGenerator generator)
     */
    public void startMatch(int matchLength)
    {
        //Basic set up for the match
        char result = ' ';
        int userSelection = 0;
        int computerSelection = 0;
        //String rawInput = null;
        match.setMatch(matchLength);
        
        System.out.println("Note: Commands (Excluding Quit) may still be executed while in match mode.");
        
        while(match.isNotOver())
        {
            //Takes in initial input
            System.out.println("Enter throw: ");
//            rawInput = input.getInput();
            
            //Determines what to do with input
            //userSelection = analyzer.determineThrow(rawInput);
            
            //If command input/invalid input
//            if(userSelection == InputAnalyzer.FAILURE_CODE)
//            { 
//                System.out.println("Invalid Command. For help type 'F' or 'H'");
//                match.invalidateRound();
//                continue;
//            }
//            else if(userSelection == InputAnalyzer.SUCCESS_CODE)
//            { match.invalidateRound();continue;}
            
            //Gets computers throw selection
            //computerSelection = computer.generateThrow();
            
            
//            //Records computer's throw
//            if(Match.ROCK == computerSelection)
//                recorder.recordThrow('R'); 
//            else if(Match.PAPER == computerSelection)
//                recorder.recordThrow('P');
//            else if(Match.SCISSORS == computerSelection)
//                recorder.recordThrow('S');
//            
//            //Records player's throw
//            if(Match.ROCK == userSelection)
//                recorder.recordThrow('R'); 
//            else if(Match.PAPER == userSelection)
//                recorder.recordThrow('P');
//            else if(Match.SCISSORS == userSelection)
//                recorder.recordThrow('S');
            
            
            
            
            //If input is a valid throw
            result = match.compare(userSelection, computerSelection);
            switch(result)
            {
                case('W'):                    
                    System.out.printf("You beat the computer! :)\n");
                    score.increasePlayerScore();
                    break;
                case('L'):
                    System.out.printf("You lost to the computer :(\n");
                    score.increaseComputerScore();
                    break;
                case('T'):
                    System.out.printf("You tied the computer :|\n");
                    score.increaseTieScore();
                    break;
                default:break;
            }
        }
        match.resetMatch();
    }    
    
    
    public void startMatch(int matchLength, ThrowGenerator generator)
    {
    	match = new Match(matchLength);//Creates a match of n length
    	
    	String rawInput = null;//Used to get input from user
    	String userThrow = null;//Used for display purposes
    	String computerThrow = null;//Used for display purposes
    	int computerSelection = -1;//int representation of throw
    	int userSelection = -1;//int representation of throw
    	char outcome = ' ';//determines comparison outcome
    	
    	System.out.printf("Match of %d length has begun.\n",matchLength);
    	System.out.printf("Note: At any time you can enter (F)/(H) for help\n");
        while(match.isNotOver())
        {
        	System.out.print("Select a throw (R) Rock (P) Paper (S) Scissors: ");
        	try 
        	{
        		//Gets throw/command from user
				rawInput = input.getInput();
			} 
        	catch (InvalidInputException e) 
        	{
        		//Invalid input, re-prompts user form throw/command
        		System.out.println("Invalid input. Please re-enter.");
        		match.invalidateRound();
        		continue;
			}
        	
        	try
        	{
        		//Determines the users throw
        		userSelection = analyzer.determineThrow(rawInput);
        	}
        	catch(InvalidCommandException e)
        	{
        		//Invalid command/throw entered.
        		System.out.println("No such command. Please re-enter.");
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
        	recorder.recordThrows(ThrowConverter.convertThrowToChar(userSelection), 
        					      ThrowConverter.convertThrowToChar(computerSelection));
        	
        	//Compares the player/computer's throw selection. Determines and displays a winner
        	outcome = match.compare(userSelection, computerSelection);
        	
        	//Converts throws to strings for display purposes
            userThrow = ThrowConverter.convertThrowToString(userSelection);
        	computerThrow = ThrowConverter.convertThrowToString(computerSelection);
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
    
    public void runGame()
    {
        ThrowGenerator throwGenerator = null;
        String rawInput = null;//Used to get user input
        int matchLength = 0;//Used to keep track of desired match length
        
        System.out.print("Enter the match length: ");
        /*Gets match length from the user*/
        while(true)
        {
            try
            {
            	rawInput = input.getInput();
                matchLength = Integer.parseInt(rawInput);
                break;
            }
            catch(NumberFormatException e)
            {
                System.out.print("Invalid integer. Please re-enter: ");
                continue;
            }
            catch(InvalidInputException e)
            {
            	System.out.print("Invalid input. Please re-enter: ");
            	continue;
            }
        }
        
        System.out.println("Select the type of A.I.");
        System.out.print("(S) Smart (R) Random:");
        /*Gets type of generator from user (Random or Smart)*/
        while(true)
        {
        	try
        	{
        		rawInput = input.getInput();
        		if( !(rawInput.equals("S") || rawInput.equals("R")) )
        		{
        			System.out.print("Only enter 'S' (Smart) or 'R' (Random):");
        			continue;
        		} 
        		break;
        	}
        	catch(InvalidInputException e)
        	{
        		System.out.println("Invalid input. Please re-enter: ");
            	continue;
        	}
        }
        
        switch(rawInput.charAt(0))
        {
            case'S':
            	System.out.println("Game mode SMART selected");
            	throwGenerator = new SmartThrow(recorder);
            	break;
            case'R':
            	System.out.println("Game mode RANDOM selected");
            	throwGenerator = new RandomThrow();
            	break;
        }
        
        startMatch(matchLength, throwGenerator);
        System.out.println("Have a good day! Hope you play again soon!");
    }
    
    public static void main(String[] args)
    {
        RockPaperScissorsGame rpsGame = new RockPaperScissorsGame();
        rpsGame.runGame();
    }
}

    /*
     * Deprecated run game, new version now prompts for match length and 
     * type of throw generator at the beginning. 
     * Old method kept here for reference
     */
//    /**
//     * Main method or run game 
//     */
//    public void runGame()
//    {
//        String rawInput = null;
//        int code = 0;
//        
//        while(userIsPlaying)
//        {
//            //Prompts user for initial command
//            System.out.println("Enter command: ");
//            rawInput = input.getInput();
//            
//            //Checks to see if input is valid
//            if(rawInput == null)
//            {
//                //If invalid print error message and continue for new input
//                System.out.println("Invalid characters."); continue;
//            }
//            
//            //If valid input determine action and see if input was a valid command
//            code = analyzer.determineAction(rawInput);
//            
//            if(code == InputAnalyzer.FAILURE_CODE)
//            {
//                //If invalid command print error message and continue for new input
//                System.out.println("Invalid command. For help type 'H' or 'F'"); continue;
//            }
//        }
//        System.out.println("Have a nice day! Come back when you have more time!");
//        System.out.println("Here's an ASCII dance to enjoy! <(0_0<) (^0_0^) (>0_0)>");
//    }
