package rockpaperscissors.ThrowGenerators;

/**
 * Interface for different types of computer algorithms to
 * generate throws.
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public interface ThrowGenerator 
{
   /**
    * Generates a throw of Rock, Paper or Scissor.
    * @return Throw Constant representing the computer's throw.
    */
    public int generateThrow();
    
    /**
     * Gets the throw the computer will make
     * @return String computer's throw
     */
    public String getComputersThrow();
    
    /**
     * Gets the throw the computer predicts the human will make
     * @return String player's predicted throw
     */
    public String getPredictedThrow();    
}