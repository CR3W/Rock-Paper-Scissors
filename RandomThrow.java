package rockpaperscissors;

import java.util.Random;

/**
 *
 * @author Eric
 */
public class RandomThrow implements ThrowGenerator
{
    private Random random;
    
    public RandomThrow()
    {
        random = new Random();
    }

    @Override
    public int generateThrow() 
    {
        return random.nextInt(3);
    }
}
