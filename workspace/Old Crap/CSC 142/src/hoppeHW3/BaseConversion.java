package hoppeHW3;

/**
 * This class stores the static base conversion methods for the Seattle Public
 * Schools Conversion Utility. It also contains a method to reverse strings.
 * 
 * @author Alexander Hoppe
 * @version 10/11/14
 */
public class BaseConversion {

    /**
     * This method takes a string argument and reverses it
     * @param input This is the input string
     * @return The input string in reverse
     */
    public static String reverse(String input){
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--){
            output += input.charAt(i);
        }
        return output;
    }
    
    /**
     * This method takes an integer in base-10 form and returns it in base-2 (binary) form
     * precondition: Input is a non-negative integer
     * @param input integer input in base-10
     * @return returns input in base-2
     */
    public static String baseTwo(int input){
        if (input < 0)                            //Precondition: x is not negative
            throw new IllegalArgumentException("Input must be non-negative");
        int a = input;
        String collector = "";         //setting up an empty string to add digits to
        while (a != 0){
            collector += a % 2;        //collecting the remainder digits in reverse order
            a = a/2;                   //setting up the next division (update step)
        }
        String output = reverse(collector); //reversing the collection string
        return output;
    }
    
    /**
     * This method takes an integer in base-10 form and returns it in base-8 (octal) form
     * precondition: input is non-negative
     * @param input The integer input in base-10
     * @return returns input in base-8
     */
    public static String baseEight(int input){
        if (input < 0)                         //Precondition: x is nonnegative
            throw new IllegalArgumentException("Input must be non-negative");
        int a = input;
        String collector = "";        //initializing collection string
        while (a != 0){
            collector += a % 8;       //collecting the remainders
            a = a/8;                  //setting up next calculation (update step)
        }
        String output = reverse(collector); //reversing collection string
        return output;
    }
    
    /**
     * This method takes an integer input in base-10 and returns its equivalent in
     * base-16 notation (hexadecimal)
     * 
     * This method uses a switch block to handle the digits greater than 9
     * precondition: input is a non-negative integer
     * @param input The integer input in base-10
     * @return The string output equivalent of the input in base-16
     */
    public static String baseSixteen(int input){
        if (input < 0)
            throw new IllegalArgumentException("Input must be non-negative");
        int a = input;
        String collector = "";
        while (a != 0){
            int result = a % 16;          //initialized to use a switch block
            switch(result){
                case 10: collector += 'A';    //accounting for digits large than 9
                        break;
                case 11: collector += 'B';
                        break;
                case 12: collector += 'C';
                        break;
                case 13: collector += 'D';
                        break;
                case 14: collector += 'E';
                        break;
                case 15: collector += 'F';
                        break;
                default: collector += result; //digits <= 9
            }
            a = a / 16;                      //setting up next calculation (update step)
        }
        String output = reverse(collector);
        return output;
    }
}
