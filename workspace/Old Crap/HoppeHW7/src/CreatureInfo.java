/**
 * The CreatureInfo interface defines a set of methods for querying the
 * state of a SeaCreature in the simulation. 
 * 
 * Based on work by Stuart Reges and Marty Stepp
 */

public interface CreatureInfo {
    /**
     * returns the neighbor in front of a specific SeaCreature
     */
    public SeaCreature.Neighbor getFront();
    
    /**
     * returns the neighbor behind of a specific SeaCreature
     */
    public SeaCreature.Neighbor getBack();
    
    /**
     * returns the neighbor to the left of a specific SeaCreature
     */
    public SeaCreature.Neighbor getLeft();
    
    
    /**
     * returns the neighbor to the right of a specific SeaCreature
     */
    public SeaCreature.Neighbor getRight();
    
    /**
     * returns the direction a specific SeaCreature is facing in the simulation
     */
    public SeaCreature.Direction getDirection();
    
    /**
     * returns the number of entities a specific SeaCreature has infected
     */
    public int getInfectCount();
}
