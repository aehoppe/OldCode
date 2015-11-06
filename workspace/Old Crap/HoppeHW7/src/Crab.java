import java.awt.Color;
import java.util.Random;

/**
 * This class extends the SeaCreature class, adding a Crab to the Ocean Simulation
 * @author Alexander Hoppe
 * @version 11/24/14
 */

public class Crab extends SeaCreature {

    //instance variables
    /**
     * This variable keeps track of the iteration in the color change sequence
     */
    private int colorChangeIteration;
    
    /**
     * This variable keeps track of the iteration in the move sequence
     */
    private int moveLoopIteration;
    
    /**
     * This variable holds on to the Random object used to determine direction
     * and color
     */
    private Random rand;
    
    /**
     * This variable holds on to the number of left turns to go if the crab is turning
     */
    private int leftsToGo;
    
    //constructor
    public Crab(){
        super(">><<", Color.WHITE);
        colorChangeIteration = 0;
        moveLoopIteration = 0;
        rand = new Random();
        leftsToGo = 0;
        newColor(); //initializing color randomly
    }
    
    /**
     * This method defines the movement for the Crab in all situations and changes
     * its color every three calls
     * @param info A PrivateData that stores this Crab's data in the simulation
     * @return this Crab's action, of enum type Action
     */
    public Action getMove(CreatureInfo info) {
        Action output;
        
        //check if it's currently turning, executes instead of normal actions
        if(leftsToGo > 0){
            output = Action.LEFT;
            leftsToGo--;
        }
        
        // unimpeded movement pattern
        else if(info.getFront() == Neighbor.EMPTY){ 
            output = unimpededMove();
        }
        
        // infect action
        else if(info.getFront() == Neighbor.OTHER){
            output = Action.INFECT;
        }
        
        // else there's something in the way, the same creature or a wall
        else{
            moveLoopIteration = 0; //reset move loop
            leftsToGo = 2; //turn around (two turns)
            output = Action.LEFT;
            leftsToGo--;
        }
        
        //color change test
        if(colorChangeIteration > 2){
            newColor(); //picks new color, resets counter
        }
        colorChangeIteration++; //increment number of rounds it has been this color
        
        return output;
    }
    
    /**
     * This method randomly picks a new color for the Crab
     */
    public void newColor(){
        int colorNum = rand.nextInt(3); //randomly selecting color
        if(colorNum == 0) setColor(Color.YELLOW);
        else if(colorNum == 1) setColor(Color.ORANGE);
        else setColor(Color.MAGENTA);
        colorChangeIteration = 0; //restart the loop
    }
    
    /**
     * This method is the standard movement pattern for the Crab if it is in empty space
     * moving forward ten times then choosing a random direction
     */
    public Action unimpededMove(){
        Action output;
        if(moveLoopIteration < 10){ //test if it still needs to move
            output = Action.MOVE;
            moveLoopIteration++;
        }
        else{                       //now it has to turn, move loop is over
            moveLoopIteration = 0;  //reset move loop
            leftsToGo = rand.nextInt(4); //chooses a random direction by turning
            output = Action.LEFT;        //a random number of times
            leftsToGo--;
        }
        return output;
    }


}
