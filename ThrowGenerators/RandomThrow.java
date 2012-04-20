package rockpaperscissors.ThrowGenerators;

import java.util.Random;

import rockpaperscissors.Match;
import rockpaperscissors.ThrowConverter;

/**
 * Throw generator that implements no special algorithm and
 * uses no basis other than a random number to generate a throw.
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class RandomThrow implements ThrowGenerator
{
    private Random random;//random object used to generate throws
    private char predictedThrow;//Player's predicted throw
    private int computersThrow;//Throw computer will make
    
    /**
     * Constructs a new RandomThrow object.
     */
    public RandomThrow()
    {
        random = new Random();
    }

    /**
     * Generates a random throw to use against the player.
     */
    @Override
    public int generateThrow() 
    {
        predictedThrow = ThrowConverter.convertToChar(random.nextInt(Match.throwChoices.length()));
        switch(predictedThrow)
        {
            case 'R': computersThrow = Match.PAPER;break;
            case 'P': computersThrow = Match.SCISSORS;break;
            case 'S': computersThrow = Match.ROCK;break;
        }
        return computersThrow;
    }
    
    /**
     * Gets the computers generated throw
     * @return String Computers throw
     */
    @Override
    public String getComputersThrow()
    {
        return ThrowConverter.convertToString(computersThrow);
    }
    
    /**
     * Gets the predicted throw
     * @return Player's predicted throw
     */
    @Override
    public String getPredictedThrow()
    {
        return ThrowConverter.convertToString(predictedThrow);
    }
}
