package rockpaperscissors.ThrowGenerators;

import java.util.Hashtable;
import java.util.Random;

import rockpaperscissors.Match;
import rockpaperscissors.ThrowRecorder;
import rockpaperscissors.Exceptions.NotEnoughDataException;
import rockpaperscissors.ThrowConverter;

/**
 * Throw generator that analyzes throw sequences between length
 * of two and five. Finds the sequences with the highest frequency
 * and applied weight, then uses it as a basis for what throw to use.
 * @author CR3W
 * @version Object-Oriented Design (CS 151)
 */
public class SmartThrow implements ThrowGenerator
{
    private ThrowRecorder recorder;//Contains users throw history
    private char predictedThrow;
    private int computersThrow;
    
    /**
     * Constructs a new SmartThrow object with the specified recorder
     * @param recorder ThrowRecorder that contains that has been used to 
     * record the user's previous throws.
     */
    public SmartThrow(ThrowRecorder recorder)
    {
        this.recorder = recorder;
    }

    /**
     * Generates a throw based on the users past history
     * and tendencies.
     * @return int representation of the selected throw
     */
    @Override
    public int generateThrow() 
    {
        //If there is enough data it will begin analysis here
        
        predictedThrow = 'R';//Sets the default thorw to ROCK
        int greatestValue = 0;//Keeps track of sequence with highest frequency
        String currentSequence = ""; //Stores current sequence being analyzed
        String originalSequence = "";//Stores the original sequence to be reused
        Integer currentValue = (Integer) 0; //Temp variable for comparing frequencies
        Hashtable<String, Integer> sequenceTable = recorder.getSequenceTable();
        
        try
        {
            //Gets the current sequence of throws between computer and human
            currentSequence = recorder.getCurrentSequence();
        }
        catch(NotEnoughDataException e)
        {
            //Exception thrown if it is too early for computer to make a 
            //proper prediction, instead a random throw is generated.
            predictedThrow = ThrowConverter.convertToChar(new Random().nextInt(3));
            switch(predictedThrow)
            {
                case 'R': computersThrow = Match.PAPER;break;
                case 'P': computersThrow = Match.SCISSORS;break;
                case 'S': computersThrow = Match.ROCK;break;
            }
            return computersThrow;
        }
        
        //If enough throws have been made sequence analysis beings
        for(int i=0;i<4;i++)
        {
            //Truncates the ith part of the sequence
            originalSequence = currentSequence.substring(i,4);
            for(int k=0;k<Match.throwChoices.length();k++)
            {
                //Appends a throw to the sequence and searches the sequence table
                currentValue = sequenceTable.get(originalSequence + Match.throwChoices.charAt(k));
                if(currentValue == null)//If returned value is null, sequence doesn't exist
                    continue;

                //Applys weight to the value based on the length of the string
                currentValue = (Integer) (currentValue.intValue() * (originalSequence.length() + 1));
                
                //Compares the current value to see if it has the greatest value
                if(currentValue.intValue() > greatestValue)
                {
                    greatestValue = currentValue.intValue();
                    predictedThrow = Match.throwChoices.charAt(k);
                }
            }
        }
        
        //Once users throw is predicted, computer will throw the opposite of 
        //the predicted throw. If for some reason no sequences could be found
        //a random throw is made by default.
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
