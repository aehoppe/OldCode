package homework_5;

import java.awt.Color;

/**
 * This class stores data for a weighted color, essentially a color associated with
 * a client-given weight, and has various useful methods such as returning weight, 
 * or brightness, setting the above, or returning it as a string.
 * @author Alexander Hoppe
 * @version 11/3/14
 */

public class WeightedColor {
    
    //fields
    /**
     * Stores the color of the WeightedColor (rgb values)
     */
    Color color;
    
    /**
     * Stores the client-provided weight of the WeightedColor
     */
    double weight;
    
    //constructor
    /**
     * This constructor instantiates a new WeightedColor object and initializes
     * it to the provided values
     * @param c The Color of the WeightedColor
     * @param weight The client-provided weight value of the color
     * @throws IllegalArgumentException If the weight argument is outside the range
     * [0, 1)
     */
    public WeightedColor(Color c, double weight){
        if(weight < 0 || 1 - weight < 0.00000000001) throw new IllegalArgumentException();
        this.color = c;
        this.weight = weight;
    }
    
    //accessors
    /**
     * accesses Color of the WeightedColor
     * @return the color as a Color object
     */
    public Color getColor(){
        return this.color;
    }
    
    /**
     * This method gets the weight of the WeightedColor
     * @return The weight value as a double
     */
    public double getWeight(){
        return this.weight;
    }
    
    /**
     * This method calculates and returns the brightness of the WeightedColor
     * @return brightness value as a double
     */
    public double getBrightness(){
        int r = color.getRed();
        int g = color.getGreen(); //just so I can visualize better
        int b = color.getBlue();
        return Math.sqrt((.241 * r * r) + (.691 * g * g) + (.068 * b * b));
    }
    
    /**
     * A toString method, returning a string representation of this WeightedColor
     * @return A string representation of this object in the form (r, g, b):w where
     * r g and b are red, green and blue, and w is weight. 
     */
    public String toString(){
        return "(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue()
                + "):" + weight;
    }
    
    //mutators
    
    /**
     * This method sets the WeightedColor's color to the input color
     * @param c The color to change the WeightedColor to.
     */
    public void setColor(Color c){
        this.color = c;
    }
    
    /**
     * This method sets the WeightedColor's weight to the argument passed in
     * @param w The weight to change the WeightedColor's weight to.
     * @throws IllegalArgumentException If the weight argument is outside the range
     * [0, 1)
     */
    public void setWeight(double w){
        if(weight < 0 || 1 - weight < 0.000000001) throw new IllegalArgumentException();
        this.weight = w;
    }

}
