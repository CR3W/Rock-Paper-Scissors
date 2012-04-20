package rockpaperscissors;

/**
* Handles score updating, match length and throw comparisons for Rock Paper Scissors game
* @author CR3W
* @version Object-Oriented Design (CS 151)
*/
public class Match
{
    //Universal constants used for throw comparisons
    public final static int ROCK = 0;
    public final static int PAPER = 1;
    public final static int SCISSORS = 2;
    public final static String throwChoices = "RPS";
    
    private int round; //Current round
    private int matchLength; //Length of match
        
   /**
    * Constructs a match object with the given match length
    * @param matchLength Length of each match
    */
    public Match(int matchLength)
    {
        this.matchLength = matchLength;
        round = 0;
    }
    
    /**
* Sets the length of the current match (can only be done when match has not been started, round 0)
* @param matchLength Desired length of match
*/
    public void setMatch(int matchLength)
    {
        if(round == 0)
            this.matchLength = matchLength;
    }
    
    /**
* Accessor for round variable
* @return current round
*/
    public int getRound()
    {
        return round;
    }
    
    /**
* Sets the current round of the match
* @param round for match to be set to
*/
    public void setRound(int round)
    {
        this.round = round;
    }
    
    /**
* Invalidates the current round
*/
    public void invalidateRound()
    {
        round--;
    }
    
    /**
* Sets match to the zero round
*/
    public void resetMatch()
    {
        round = 0;
    }
    
    /**
* Checks to see if the current match is over
* @return true if match is NOT over, otherwise false.
*/
    public boolean isNotOver()
    {
        return round++ != matchLength;
    }
    
    /**
* Compares the Player's throw with the Computer's throw (0 = rock, 1 = paper, 2 = scissors)
* @param playerThrow player's throw selection
* @param computerThrow computer's throw selection
* @return 'W' if Player has won, 'L' if Player has lost, 'T' if there was a tie
*/
    public char compare(int playerThrow, int computerThrow)
    {
        //Checks for tie (Throw values are the same)
        if(playerThrow == computerThrow)
            return 'T';
        
        //Checks loss conditions
        if(playerThrow == ROCK && computerThrow == PAPER)
            return 'L';
        if(playerThrow == PAPER && computerThrow == SCISSORS)
            return 'L';
        if(playerThrow == SCISSORS && computerThrow == ROCK)
            return 'L';
        
        //If not a loss or tie, the user has won
        return 'W';
    }
}