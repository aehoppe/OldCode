package homework_5;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * This class represents an array of WeightedColors generated from a text file, 
 * and also contains a couple of methods manipulating said list. The most important
 * of which is getNonDecSeq(), which gets the longest non-decreasing sequence of
 * brightness values in the set.
 * @author Alexander Hoppe
 * @version 11/3/14
 * 
 * EXTRA CREDIT:
 * Helper methods should be private as they are not intended to be used outside
 * the class, and they are also not specified as part of the public interface, 
 * thus clients should not have access to them. Also, they probably wouldn't make
 * sense to be used outside the class.
 */
public class WColorSet {
    
    //Constants
    /**
     * This is the dimension of the squares the drawSequence() method draws
     */
    private static final int SQUARE_DIM = 50;
    
    /**
     * This is the spacing between the squares in the drawSequence method
     */
    private static final int SPACING = 10;
    
    //Instance Variables
    /**
     * This array stores the WeightedColors from the file
     */
    private WeightedColor[] weightedColors;
    
    //Constructor
    /**
     * This constructor takes a file as an input and converts that file into an
     * array of WeightedColor objects. 
     * @param source The file to read in
     * @throws FileNotFoundException If there's no file to be passed in
     */
    public WColorSet(File source) throws FileNotFoundException{
        Scanner input = new Scanner(source);
        int arrLength = input.nextInt();
        weightedColors = new WeightedColor[arrLength];
        for(int i = 0; i < arrLength; i++){
            int r = input.nextInt();
            int g = input.nextInt();
            int b = input.nextInt();
            double weight = input.nextDouble();
            Color c = new Color(r, g, b);
            weightedColors[i] = new WeightedColor(c, weight);
        }
    }
    
    //accessors
    /**
     * This method gets the number of WeightedColors in the set
     * @return The number of WeightedColors as an int
     */
    public int getCount(){
        return weightedColors.length;
    }
    
    /**
     * This method calculates the sum of the brightness * weight for each object 
     * in the WColorSet
     * @return sum of brightness * weight for all elements as a positive double
     */
    public double calculate(){
        double total = 0;
        for(int i = 0; i < this.getCount(); i++){
            total += weightedColors[i].getBrightness() * weightedColors[i].getWeight();
        }
        return total;
    }
    
    /**
     * This method returns an array of doubles that is the brightness of all elements
     * of WColorSet.
     * @return a double[] of brightness values
     */
    public double[] getBrightness(){
        double[] output = new double[weightedColors.length];
        for(int i = 0; i < weightedColors.length; i++){
            output[i] = weightedColors[i].getBrightness();
        }
        return output;
    }
    
    /**
     * This method compares the weight of each WeightedColor in the WColorSet to
     * the next one in the set, if it increases, tally increases, if it decreases,
     * tally decreases. Returns tally.
     * @return An integer representing how many times the weight was greater than
     * the previous weight
     */
    public int weightChange(){
        int tally = 0;
        for(int i = 1; i < weightedColors.length; i++){
            if(weightedColors[i - 1].getWeight() < weightedColors[i].getWeight()){
                tally += 1;
            } else if (weightedColors[i - 1].getWeight() < weightedColors[i].getWeight()){
                tally -= 1;
            }
        }
        return tally;
    }
    
    /**
     * This method returns the longest non-decreasing series of brightness values
     * in the WColorSet as a WeightedColor[] and also as graphical output. 
     * @return Longest non-decreasing (brightness) sequence in the WColorSet as
     * a WeightedColor[]
     */
    public WeightedColor[] getNonDecSeq(){
        int startIdx = 0;
        int endIdx = 1;   //stores the start and end of the sequence
        int length = 1;
        int maxStart = 0;
        int maxEnd = 1;
        int maxLength = 1;
        double[] brightness = this.getBrightness();
        int testIndex = 1;
        while(testIndex < weightedColors.length){
            while(brightness[testIndex-1] <= brightness[testIndex] && testIndex < weightedColors.length){
                endIdx = testIndex + 1; //bringing the end index along while it's non-decreasing
                length++;
                testIndex++;
            }
            if(length > maxLength){ //once the non-dec. seq. terminates, if it's 
               maxLength = length;  //the longest one so far, store those values
               maxStart = startIdx;
               maxEnd = endIdx;
            }
            startIdx = testIndex; //starting the new sequence
            length = 1;
            testIndex++;
        }
        WeightedColor[] output = getSubArray(maxStart, maxEnd);
        //Here's where I switch to the graphical output code
        NonDecSeqGraphics(output);
        return output;
    }
    
    /**
     * EXTRA CREDIT:
     * 
     * This method takes a WeightedColor[] and creates a DrawingPanel with blocks
     * of color corresponding to the WeightedColor[] passed in, and corresponding 
     * brightness values next to each block of color.
     * @param wcArr The WeightedColor[] to be represented graphically
     */
    private static void NonDecSeqGraphics(WeightedColor[] wcArr){
        int height = wcArr.length * (SPACING + SQUARE_DIM);
        DrawingPanel dp = new DrawingPanel(SQUARE_DIM + 70, height);
        Graphics g = dp.getGraphics();
        for(int i = 0; i < wcArr.length; i++){
            g.setColor(wcArr[i].getColor());
            g.fillRect(0, i * (SQUARE_DIM + SPACING), SQUARE_DIM, SQUARE_DIM);
            g.setColor(Color.black);
            double rawBrightness = wcArr[i].getBrightness();
            String outputBrightness ="" + (double)Math.round(rawBrightness * 1000) / 1000;
            g.drawString(outputBrightness, SQUARE_DIM + SPACING,
                   i * (SQUARE_DIM + SPACING) + SQUARE_DIM);
        }
    }
    
    /**
     * This method returns a WeightedColor[] from the start index to the end index
     * @param start The first index to include in the WeightedColor[]
     * @param end The first index not to be included
     * @return The desired WeightedColor[]
     */
    private WeightedColor[] getSubArray(int start, int end){
        WeightedColor[] output = new WeightedColor[(end - start)];
        for(int i = 0; i < output.length; i++){
            output[i] = this.weightedColors[start + i];
        }
        return output;
    }
    
    
}
