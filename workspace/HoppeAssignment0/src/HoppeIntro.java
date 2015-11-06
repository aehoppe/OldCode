/**
 * Assignment 1 class file that works with command line args
 * @author Alexander Hoppe
 * @version Assignment 1: Class Tools
 */
public class HoppeIntro {
    
    /**
     * The main method that writes my name and handles arguments
     * @param args The String[] of command line arguments
     */
    public static void main(String[] args){
        //prints my name
        System.out.println("Alexander Hoppe");
        
        //prints my interesting fact
        System.out.println("Bananas are slightly radioactive due to high levels"
                + " of Potassium-40");
        
        //handles arguments
        if(args.length == 0){
            System.out.println("No command-line arguments given");
        } else if (args[0].equals("OOP")){
            System.out.println("The command-line arguments say \"OOP\"");
        } else if (args[0].equals("CSC") && args[1].equals("143")){
            System.out.println("The command-line arguments say \"CSC 143\"");
        } else {
            System.out.println("The command-line arguments are not recognized");
        }
        
    }

}
