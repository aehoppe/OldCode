import java.awt.Color;

/**
 * This class, Eel, extends SeaCreature, adding an Eel that swims in circles to the Ocean Simulator
 * @author Alexander Hoppe
 * @version 11/26/14
 */
public class Eel extends SeaCreature {

    //Instance variables
    /**
     * This variable holds on to where in the move pattern the Eel is
     */
    private int moveSequenceIteration;
    
    //Constructor
    /**
     * This constructor initializes all the fields of this Eel, setting the move sequence to 0
     */
    public Eel(){
        super("S", Color.GREEN);
        moveSequenceIteration = 0;
    }
    
    /**
     * This method dictates the actions of the Eel each round
     * @param info The PrivateData that stores this Eel's info
     * @return this Eel's action, of enum type Action
     */
    public Action getMove(CreatureInfo info) {
        Action output = null;
        Neighbor n = info.getFront();
        switch(n){
        case WALL:
        case SAME:
            output = Action.RIGHT; //if it hits something, turn right
            break;
        case OTHER:
            output = Action.INFECT; //if there's something else in front, infect
            break;
        case EMPTY:
            output = unimpededMove(); //if there's nothing in front,
            break;                    //proceed with standard move sequence
        }
        return output;
    }


    /**
     * This method determines the move the Eel would make if nothing is in front of it
     */
    public Action unimpededMove(){
        if(moveSequenceIteration < 5){ //moves forward five times
            moveSequenceIteration++;
            return Action.MOVE;
        }
        else{                          //once it's moved five times, turn and reset loop
            moveSequenceIteration = 0;
            return Action.RIGHT;
        }
    }
}
