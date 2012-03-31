package rockpaperscissors;

import java.util.Hashtable;

/**
 * Records users throws for computer analysis. This class records throws in pairs.
 * That is, it records a set of throws containing one (1) computer throw and
 * one (1) human throw. The throw sequences is represented as a string. For 
 * example, if C = Computer Throw and H = Human throw, the most recent sequence
 * of throws would appear as <B>"CHCHCH"</B>. Where the leftmost throw is the most recent
 * throw and the rightmost throw is the oldest throw.
 * @author Eric Castro
 */
public class ThrowRecorder 
{    
    private final static int MAX_RECORD_LENGTH = 6;//MUST BE A MULTIPLE OF TWO
    private final static int MAX_SEQUENCE_LENGTH = 5;//Maximum lenght of sequence recorded (Usually MAX_RECORD_LENGTH - 1)
    private final static int MINIMUM_DATA_THRESHOLD = 14;//Minimum data needed before predictions start being made
    
    private Hashtable<String, Integer> sequenceTable;
    private String currentSequence;
    private Integer value;
    
    private int totalRecordedThrows;
    
    /**
     * Creates a ThrowRecorder object with a blank data structure and no current
     * sequence.
     */
    public ThrowRecorder()
    {        
        sequenceTable = new Hashtable<String, Integer>();
        currentSequence = "";
        totalRecordedThrows = 0;
        value = (Integer) 0;
    }
    
    /**
     * Records the pair of throws with the computer's throw being the first
     * throw recorded. Then the humans after. Paris are recorded as CH (Where C
     * is the computer's throw and H is the humans throw)
     * @param throwSelection throw to be recorded 
     */
    public void recordThrows(char computerThrow, char userThrow)
    {
        totalRecordedThrows+=2;
        if(currentSequence.length()<MAX_RECORD_LENGTH)
            currentSequence+= computerThrow + "" + userThrow;
        else
            currentSequence = currentSequence.substring(2, MAX_SEQUENCE_LENGTH+1) + computerThrow + "" +  userThrow;     
        
        for(int i=1;i<MAX_SEQUENCE_LENGTH-1;i++)
        {
            try
            {
                updateSequenceTable(currentSequence.substring(i, MAX_SEQUENCE_LENGTH));
            }
            catch(StringIndexOutOfBoundsException e)
            {
                //hanldes special cases where string length is not long enough
                //for standard operationst to be applied
                if(currentSequence.length()==2)
                    updateSequenceTable(currentSequence);
                else if (currentSequence.length()==4)
                {
                    updateSequenceTable(currentSequence);
                    updateSequenceTable(currentSequence.substring(1,4));
                    updateSequenceTable(currentSequence.substring(2,4));
                }
            }
        }
    }
    
    /**
     * Returns the current sequences of throw by both the computer and user.
     * The sequence that is returned contains four (4) throws alternating
     * between the computer and human.
     * For example. Let C = Computer Throw and H = Human Throw
     * The string representing the returned sequence would appear as: <B>HCHC</B>.
     * The returned string will always be in this order. The most recent throw
     * will always be the Computers throw. <B>THIS IS ONLY TO BE USED WHEN AT 
     * LEAST 6 THROWS HAVE BEEN RECORDED. THAT IS 3 ROUNDS OF ROCK PAPER SCISSORS
     * HAVE BEEN PLAYED.</B>
     * @exception NotEnoughDataException Less than 6 throws have been recorded
     * @return String - Current Sequence
     */
    public String getCurrentSequence() throws NotEnoughDataException
    {
        if(totalRecordedThrows<=MINIMUM_DATA_THRESHOLD)
            throw new NotEnoughDataException("Not enough data has been recorded"
                    + "to make an accurate prediction yet. " + (MINIMUM_DATA_THRESHOLD - totalRecordedThrows)
                    + "needed until current sequence can be retrieved");
            
        //Truncates most recent throw and previous throw
        return currentSequence.substring(1, MAX_RECORD_LENGTH-1);
    }
    
    /**
     * Allows access for the Hashtable that contains all the sequences of
     * throws that have been encountered so far into the game.
     * @return <b>Hashtable<String, Integer> </b> - Key - the sequence, Value - number of times encountered
     */
    public Hashtable<String, Integer> getSequenceTable()
    {
        return sequenceTable;
    }
    
    /**
     * Accessor for the counter that keeps track of the number of throws that
     * have been recorded
     * @return int
     */
    public int getTotalRecordedThrows()
    {
        return totalRecordedThrows;
    }
    
    /**
     * Adds the current sequences to the Hashtable.
     * @param sequence to be added
     */
    private void updateSequenceTable(String sequence)
    {
        value = sequenceTable.get(sequence);
       
        //Checks to see if the sequence existed
        if(value == null)
            //If it didn't exist, add the sequence to the Hashtable
            sequenceTable.put(sequence, (Integer) 1);
        else
            //If it did exist, increment the value of the sequence by one
            sequenceTable.put(sequence, (Integer) value.intValue() + 1);
    }
}
