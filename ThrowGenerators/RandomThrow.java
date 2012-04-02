package rockpaperscissors.ThrowGenerators;

import java.util.Random;

import rockpaperscissors.Match;

/**
 * Throw generator that implements no special algorithm and
 * uses no basis other than a random number to generate a throw.
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class RandomThrow implements ThrowGenerator
{
    private Random random;//random object used to generate throws
    
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
        return random.nextInt(Match.throwChoices.length());
    }
}
