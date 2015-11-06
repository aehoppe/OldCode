import java.util.*;


/**
 * This class implements the user interface for the Sieve class. It takes a number
 * input from the user and displays all primes up to that number
 * @author Alexander Hoppe
 * @version 12/3/14
 */
public class SieveInterface {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        intro();
        int num = 1;
        boolean proceed = false;
        boolean quit = false;
        while(!quit){
            while(!proceed){ //input validation
                while(!console.hasNextInt()){ //type validation
                    System.out.println("Please enter an integer value:");
                    console.next();
                }
                num = console.nextInt();
                if (num == 0){
                    proceed = true; //exit sentinel
                    quit = true;
                } else if(num < 2){
                    System.out.println("Please enter a maximum integer greater than 1");
                } else {
                    proceed = true; //normal, valid condition
                }
            }
            proceed = false; //reset validation loop
            //main program
            if(!quit){
                ArrayList<Integer> result = Sieve.findPrimes(num);
                System.out.println("Primes up to " + num + " are as follows:"); //introduce output
                constructOutput(result);                                        //print ArrayList
                double percentPrime = (((double) result.size()) / num) * 100;              //calculate percentage
                System.out.print("%");
                System.out.printf(" prime = %.1f \n", percentPrime);            //print percentage
                System.out.println("Try another? Enter a maximum integer greater than 1");
                System.out.println("or enter 0 to quit.");
            }
        }
        System.out.println("Thanks for using Sieve of Eratosthenes 2014");
    }
    
    /**
     * This method prints the intro sequence for the program. 
     */
    private static void intro(){
        System.out.println("Welcome to Sieve of Eratosthenes 2014");
        System.out.println("This program takes the number you enter and displays");
        System.out.println("all the prime integers less than that number.");
        System.out.println("When you are finished, enter 0");
        System.out.println("Please enter a maximum integer greater than 1");
    }
    
    /**
     * This method constructs the output of an ArrayList<Integer>
     * @param a The ArrayList<Integer> to be printed
     */
    private static void constructOutput(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            if(i % 12 == 0) //line break every 12 lines
                System.out.println();
            System.out.printf("%d ", a.get(i)); //unnecessary printf, but y'know, it's cool.
        }
        System.out.println();
    }

}
