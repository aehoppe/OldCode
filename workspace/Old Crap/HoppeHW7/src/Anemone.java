import java.awt.Color;
import java.util.Random;

/**
 * This class extends the SeaCreature Class, adding an Anemone to the Ocean Simulator. 
 * It also adds an infectCount instance variable.
 * @author Alexander Hoppe
 * @version 11/24/14
 */
public class Anemone extends SeaCreature {
    
    //constructor
    /**
     * Default constructor
     */
    public Anemone(){
        super("A", Color.BLUE);
    }

    //accessor methods
    /**
     * This method returns the next move for this Anemone
     * @param info An object that implements CreatureInfo
     * @return the anemone's next move of type Action
     */
    public Action getMove(CreatureInfo info) {
        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else{
            Random rand = new Random();
            boolean turnLeft = rand.nextBoolean();
            if(turnLeft) return Action.LEFT;
            else return Action.RIGHT;
        }
    }

}
