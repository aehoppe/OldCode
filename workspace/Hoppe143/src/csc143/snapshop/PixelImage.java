package csc143.snapshop;

import java.awt.image.*;

/**
 * Provides access to an image as an array of Pixels
 * 
 * @author Richard Dunn
 * @author Donald Chinn
 * @author Dan Jinguji
 * @version March 1, 2002
 */

public class PixelImage
{
    private BufferedImage myImage;
    private int width;
    private int height;

    /**
     * Construct a PixelImage from a Java BufferedImage
     * @param bi The image
     */
    public PixelImage(BufferedImage bi)
    {
        // initialise instance variables
        this.myImage = bi;
        this.width = bi.getWidth();
        this.height = bi.getHeight();
    }

    /**
     * Return the width of the image
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return the height of the image
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Return the image's pixel data as an array of Pixels.  
     * @return The array of pixels
     */
    public Pixel[][] getData() {

    /* The Raster has origin 0,0 , so the size of the 
     * array is [width][height], where width and height are the 
     * dimensions of the Raster
     */
        Raster r = this.myImage.getRaster();
        Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
        int[] samples = new int[3];

        // Translates from java image data to Pixel data
        for (int row = 0; row < r.getHeight(); row++) {
            for (int col = 0; col < r.getWidth(); col++) {
                r.getPixel(col, row, samples);
                Pixel ourPixel = new Pixel(samples[0], samples[1], samples[2]);
                data[row][col] = ourPixel;
            }
        }
        return data;
    }

    /**
     * Set the image's pixel data from an array.  This array must match
     * that returned by getData() in terms of dimensions. 
     * @param data The array to pull from
     * @throws IllegalArgumentException if the passed in array does not match
     *   the dimensions of the PixelImage or has pixels with invalid values
     */

    public void setData(Pixel[][] data) throws IllegalArgumentException {
        WritableRaster wr = this.myImage.getRaster();

        if (data.length != wr.getHeight()) {
            throw new IllegalArgumentException("Array size does not match");
        } else if (data[0].length != wr.getWidth()) {
            throw new IllegalArgumentException("Array size does not match");
        }

        // Translates from an array of Pixel data to java image data
        for (int row = 0; row < wr.getHeight(); row++) {
            for (int col = 0; col < wr.getWidth(); col++) {
                wr.setPixel(col, row, data[row][col].rgb);
            }
        }
    }

    /** 
     * IGNORE THIS METHOD -- you won't need it
     */
    public BufferedImage getImage() {
        return this.myImage;
    }
}
