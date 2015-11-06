import java.awt.Color;

/**
 * This class extends the SeaCreature class, adding an Octopus to the Ocean Simulator
 * Octopi are very reclusive, and don't like to leave their home ranges. 
 * @author Alexander Hoppe
 * @version 11/26/14
 */
public class Octopus extends SeaCreature {
    
    /**
     * This is the default movement of the octopus, in a figure 8 pattern
     */
    public static final Action[] moveLoop = {Action.MOVE, Action.MOVE, Action.RIGHT,
        Action.MOVE, Action.MOVE, Action.RIGHT, Action.MOVE, Action.MOVE, Action.RIGHT,
        Action.MOVE, Action.MOVE, Action.MOVE, Action.MOVE, Action.LEFT, Action.MOVE, 
        Action.MOVE, Action.LEFT, Action.MOVE, Action.MOVE, Action.LEFT, Action.MOVE,
        Action.MOVE};

    //Instance Variables
    /**
     * This keeps track of where in the standard move loop we are
     */
    int moveLoopIteration;
    
    /**
     * This keeps track of how many more lefts we have to make if we're turnign around
     */
    int leftsToGo;
    
    //constructor
    /**
     * This constructor initializes the Octopus to COLOR.PURPLE and ^v&v^
     */
    public Octopus(){
        super("^v&v^", Color.PINK);
        moveLoopIteration = 0;
        leftsToGo = 0;
    }
    
    /**
     * This method returns this Octopus' action in all situations, a rotating 
     * figure-8 pattern
     * @param a PrivateData that stores this Octopus' state in the simulator
     * @return this Octopus' action of enum type Action
     */
    public Action getMove(CreatureInfo info) {
        Action output = null;
        Neighbor n = info.getFront();
        switch(n){
        case SAME:
        case WALL: //if it hits something, turn around.
            leftsToGo = 2;
            break;
        case OTHER: //if it sees something else, infect.
            output = Action.INFECT;
            break;
        case EMPTY: //if there's nothing, proceed with the loop.
            if(moveLoopIteration > moveLoop.length - 1){
                moveLoopIteration = 0;  //if we reach the end of the loop, reset it
            }
            output = moveLoop[moveLoopIteration]; //get the action at current index
            moveLoopIteration++;                  //move index along
            break;
        }
        if (leftsToGo > 0){ //this will only execute if it hits something and has to turn around
            output = Action.RIGHT;
            leftsToGo--;
            n = null;
        }
        return output;
    }

}
