package rockpaperscissors;

/**
* Handles score tracking for the rock paper scissors game
* @author CR3W
* @version Object-Oriented Design (CS 151)
*/
public class Score
{
    //Variables used for tracking scores
    private int playerScore;
    private int computerScore;
    private int tieScore;
    
    /**
* Creates score object with all initial scores set to zero
*/
    public Score()
    {
        playerScore = 0;
        computerScore = 0;
        tieScore = 0;
    }
    
    /**
* Creates Score object with scores initialized to those in their respective parameter
* @param playerScore Initial Player score
* @param computerScore Initial Computer score
* @param tieScore Initial number of ties
*/
    public Score(int playerScore, int computerScore, int tieScore)
    {
        this.playerScore = playerScore;
        this.computerScore = computerScore;
        this.tieScore = tieScore;
    }
    
    /**
* Increments the Player's score by one
*/
    public void increasePlayerScore()
    {
        playerScore++;
    }
    
    /**
* Increments the Computer's score by one
*/
    public void increaseComputerScore()
    {
        computerScore++;
    }
    
    /**
* Increments the tie count by one
*/
    public void increaseTieScore()
    {
        tieScore++;
    }
    
    /**
* Returns the score information of all three variables (Player, Computer, Tie) variables in a readable format
* @return Score information
*/
    public String getScores()
    {
        return "Player: " + playerScore + "| Computer: " + computerScore + "| Tie: " + tieScore;
    }
}