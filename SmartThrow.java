package rockpaperscissors;

import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author Eric
 */
public class SmartThrow implements ThrowGenerator
{
    private ThrowRecorder recorder;
    
    public SmartThrow(ThrowRecorder recorder)
    {
        this.recorder = recorder;
    }

    @Override
    public int generateThrow() 
    {
        //If there is enough data it will begin analysis here
        
        char predictedThrow = 'R';//Sets the default thorw to ROCK
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
            return new Random().nextInt(3);
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
            case 'R': return Match.PAPER;
            case 'P': return Match.SCISSORS;
            case 'S': return Match.ROCK;
            default: return new Random().nextInt(Match.throwChoices.length());
        }
    }
    
}
