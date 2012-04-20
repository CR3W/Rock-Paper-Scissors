package rockpaperscissors;

/**
* Contains help and general information about the rock paper scissors game
* @author CR3W
* @version Object-Oriented Design (CS 151)
*/
public class Features
{
    /**
* Contains information about the Rock Paper Scissors game
* @return String containing game information
*/
    public static String getFeaturesInformation()
    {
        return "Welcome to the Rock Paper Scissors Game!\n"
                + "Try and beat the computer in a game or Rock Paper Scissors!\n"
                + "Here are the commands you can use:\n"
                + "F - Display this information screen\n"
                + "H - See 'F'\n"
                + "D - Display the current score count\n"
                + "R - Select ROCK as your throw\n"
                + "P - Select PAPER as your throw\n"
                + "S - Select SCISSOR as your throw\n"
                + "Have fun! \n";
    }
}