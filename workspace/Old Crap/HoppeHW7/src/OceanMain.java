/**
 * ForestMain provides the main method for a simple simulation program.  Alter
 * the number of each entity added to the simulation if you want to experiment
 * with different scenarios.  You can also alter the width and height passed to
 * the ForestFrame constructor.

 * by Stuart Reges and Marty Stepp
 */

public class OceanMain {
    
    public static final int COUNT = 30;
    public static void main(String[] args) {
        OceanFrame frame = new OceanFrame(60, 40);

//         uncomment each of these lines as you complete these classes
         frame.add(COUNT, Anemone.class);
         frame.add(COUNT, Herring.class);
         frame.add(COUNT, Crab.class);
         frame.add(COUNT, Eel.class);
         frame.add(COUNT, Octopus.class);

        frame.start();
    }
}
