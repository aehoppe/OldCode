import java.awt.Color;

/**
 * This class extends the SeaCreature class, adding a Herring to the Ocean Simulation
 * @author Alexander Hoppe
 * @version 11/24/14
 */

public class Herring extends SeaCreature {
    //Instance Variables
    private int patternIndex; //keeps track of position in sequence of moves
    
    // constructor
    /**
     * This constructor initializes the Herring's appearance to "HER" and sets the
     * color to RED
     */
    public Herring(){
        super("HER", Color.RED);
        patternIndex = 0;
    }
    
    //accessor Methods
    /**
     * This method returns the action for this Herring on teh next update.
     * @param info An object of type CreatureInfo 
     * @return The Action for this Herring. 
     */
    public Action getMove(CreatureInfo info) {
        Action[] pattern = { Action.MOVE, Action.LEFT, Action.MOVE, Action.RIGHT };
        Action output;               //setup output variable
        if(info.getFront() != Neighbor.EMPTY){
            patternIndex = 0;
            output = Action.LEFT;      //if colliding, turn left
        }
        else{
            if (patternIndex == 4) patternIndex = 0;  // making sure patternIndex doesn't exceed 4
            patternIndex ++;      //update step comes before return so method doesn't end
            output = pattern[patternIndex - 1]; //return previous index b/c pre-update
        }
        if (output.equals(Action.MOVE)) toggleDisplay(); //if it moves, toggle the display
        return output;
    }
    
    /**
     * This method toggles the display between "HER" and "RING" when it is called
     */
    private void toggleDisplay(){
        if(toString() == "HER") setDisplay("RING");
        else setDisplay("HER");
    }
}
