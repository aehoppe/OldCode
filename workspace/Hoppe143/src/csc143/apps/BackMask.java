package csc143.apps;

import java.io.*;
import java.util.Scanner;

import csc143.data_structures.*;

/**
 * This class implements a small backmasking app that works with .dat files from 
 * the command line.
 * @author Alexander Hoppe
 * @version May 12, 2015
 */
public class BackMask {

    /**
     * This is the main method, it manages the command line arguments and decides
     * which type of stack and queue to use
     * @param args the command line arguments passed in
     */
    public static void main(String[] args) {
        //variables
        String inputfile = "";
        String outputfile = "";
        boolean useArrays = false;
        
        //test for valid input
        if (args.length != 2 && args.length != 3) {
            System.err.println("usage: appname.jar input-file output-file [boolean:"
                    + "useArrays]");
        } else {
            //take in command line args
            inputfile = args[0];
            outputfile = args[1];
            if (args.length == 3) {
                useArrays = Boolean.parseBoolean(args[2]);
            }
            
            //run appropriate backmasking method
            backmask(inputfile, outputfile, useArrays);
        }
    }
    
    /**
     * This helper method does the work of backmasking the input file using 
     * linked list  or array data structures from csc143.data_structures
     * @param inputfile the file to be backmasked
     * @param outputfile the backmasked file
     * @param useArrays
     */
    private static void backmask(String inputfile, String outputfile, 
            boolean useArrays) {
        //handles IOExceptions
        try {
            //setup
            Scanner reader = new Scanner(new File(inputfile));
            PrintStream output = new PrintStream(outputfile);
            //time is a queue so it comes out in the same order
            UnboundedQueue time = null;
            //amplitude is a stack so it comes out reversed
            UnboundedStack amplitude = null;
            
            if (useArrays) {
                time = new ArrayUnboundedQueue();
                amplitude = new ArrayUnboundedStack();
            } else { 
                time = new SampleUnboundedQueue();
                amplitude = new SampleUnboundedStack();
            }
            //copy the first two lines of the file to the new file
            output.println(reader.nextLine());
            output.println(reader.nextLine());
            
            //read the values into the stack and queue
            int count = 0;
            while (reader.hasNext()) {
                time.add(reader.next());
                amplitude.push(reader.next());
                count++;
            }
            
            //write the values into the file
            for (int i = 0; i < count; i++) {
                output.printf("%20s %20s \n", time.remove(), amplitude.pop());
            }
            
            //close streams
            reader.close();
            output.close();
        } catch (IOException e) {
            System.err.println("File IO error: " + e.getMessage());
        } catch (TheQueueIsDieting e) {
            System.err.println("Time queue empty: " + e.getMessage());
            e.printStackTrace();
        } catch (TheStackIsSadAndLonely e) {
            System.err.println("Amplitude stack empty: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
        
}
