package csc143.snapshop;

/**
 * Represents a pixel, which is made up of a red, green, and blue value
 * 
 * @author Richard Dunn
 * @author Barbara Goldner
 * @author Dan Jinguji
 * @version April 2002
 */

public class Pixel
{
    
    public static final int RED = 0, GREEN = 1, BLUE = 2;
    
    // RGB color values for this pixel (0-255)
    public int[] rgb;
    
    /**
     * Constructor for objects of class Pixel
     * Initializes the pixel values;
     * @param red value for red portion of pixel
     * @param green value for green portion of pixel
     * @param blue value for blue portion of pixel
     * @throws IllegalArgumentException if any of the parameters
     * are not within the bounds of 0 - 255
     */
    public Pixel(int red, int green, int blue)
    {
        if ((red < 0 || red > 255) ||
            (green < 0 || green > 255) ||
            (blue < 0 || blue > 255))
            throw new IllegalArgumentException("bad RGB value for Pixel");
        
        rgb = new int[3];
        rgb[RED] = red;
        rgb[GREEN] = green;
        rgb[BLUE] = blue;
    }
}
