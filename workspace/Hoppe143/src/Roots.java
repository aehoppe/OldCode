/**
 * This class contains static methods to find the square root and cube root of given values.
 * To find these values, this class uses Newton's Method.
 * @author Alexander Hoppe
 * @version 11 Apr 2015
 */
public class Roots {
    
    //fields
    private static final int MAX_CYCLES = 100;
    
    //constructor (sort of)
    /**
     * Since this class only holds static methods, it doesn't need to be instantiated
     */
    private Roots(){ }
    
    //methods
    /**
     * This method uses Newton's Method to approximate the square root of a value.
     * If it does not converge after 100 cycles, it will throw an exception.
     * @param input The value of which to find the square root 
     * @return The square root of the input value
     */
    public static double sqrt(double input){
        if (input < 0) throw new IllegalArgumentException("Can't take the square root of negative values!");
        if (input == 0) return 0; //avoid dividing by zero later
        int count = 1; //cycle will run once before incrementing
        double xn = input; 
        double xn1 = 0;
        boolean equal = false;
        
        //iterates until approximately equal
        while (!equal){
            if (count > MAX_CYCLES) throw new NonConvergenceException("Did not converge for value " + input);
            xn1 = (xn + input/xn)/2;
            equal = closeEnough(xn1, xn); //testing approximation
            xn = xn1; //switching values 
            count++; //making sure we don't iterate too long
        }
        
        //the values are effectively the same at this point
        return xn;
    }
    
    /**
     * This method uses Newton's Method to approximate the cube root of a value.
     * If it does not converge after 100 cycles, it will throw an exception.
     * @param input The value of which to find the cube root
     * @return The cube root of the input value
     */
    public static double cbrt(double input){
        //no need to test for positivity with the cube root function
        if (input == 0) return 0; //avoid dividing by zero later
        int count = 1; //cycle will run once before the increment
        double xn = input; 
        double xn1 = 0;
        boolean run = true;
        
        //runs until they're effectively equal
        while (run){
            if (count > MAX_CYCLES) throw new NonConvergenceException("Did not converge for value " + input);
            xn1 = (2 * xn + input/(xn * xn))/3;
            run = !closeEnough(xn1, xn); //testing approximation
            xn = xn1; //swapping values
            count++; //keeping track of iterations
        }
        
        //the values are effectively the same at this point
        return xn;
    }
    
    /**
     * This method tests to see if two doubles are "close enough" by comparing 
     * the ratio of the values to one within 9 decimal places of accuracy. 
     * @param a The first value to be compared 
     * @param b The second value to be compared
     * @return True if the values are "close enough"
     */
    private static boolean closeEnough(double a, double b){
        boolean output = false;
        if (Math.abs(Math.abs(a/b)-1) < 0.000000001) output = true;
        return output;
    }
}
