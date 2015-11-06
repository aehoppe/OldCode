package hoppeHW3;

/**
 * This class is the user interface for the Seattle Public Schools Conversion Utility
 * It handles user interaction and calls methods from the BaseConversion class
 * 
 * @author Alexander Hoppe
 * @version 10/11/14
 */

import java.util.Scanner;

public class BaseConversionApp {

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to Seattle Public Schools Conversion Utility");
        System.out.println();
        System.out.println("This program takes positive integers (base-10) and converts them into");
        System.out.println("either base-2 (binary), base-8 (octal) or base-16 (hexadecimal).");
        System.out.println("At any time, you man enter 0 0 to quit.");   //introduction
        System.out.println();
        boolean end = false;   //flag variable
        do {                                                        //data validation loop
            System.out.println("Enter an integer and the new base separated by spaces:");
            System.out.print(">> ");
            int input = console.nextInt();
            int newBase = console.nextInt();
            if(input < 0){   //invalid input
                System.out.println("You entered an invalid number to be converted.");
                System.out.println("Please enter a positive integer next time.");
            } else if (newBase < 0) {  //invalid base
                System.out.println("You entered an invalid base.");
                System.out.println("Please enter either 2, 8 or 16 as your base next time.");
            } else if (input == 0 && newBase == 0){   //exit sentinel
                System.out.println("Thank you for using Seattle Public Schools Conversion Utility");
                System.out.println("Goodbye!");
                end = true;
            } else {   //conversion
                System.out.println(input + " in base-10 is equivalent to " 
                        + convert(input, newBase) + " in base-" + newBase);
                System.out.println();
            }
        }
        while (!end);   //testing flag variable
    }
    
    /**
     * This method takes the input number and the base to be converted to and calls
     * the conversion methods on them from the BaseConversion class
     * @param input The number to be converted
     * @param base The base to convert input to
     * @return The input in the requested base
     */
    public static String convert(int input, int base){
        if (base == 2){
            return BaseConversion.baseTwo(input);
        } else if (base == 8){
            return BaseConversion.baseEight(input);
        } else {
            return BaseConversion.baseSixteen(input);
        }
    }
}
