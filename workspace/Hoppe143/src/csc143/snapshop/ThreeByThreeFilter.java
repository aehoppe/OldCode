package csc143.snapshop;

/**
 * This class forms a superclass for all three by three filters, implementing their
 * filtering based on the values stored in their weights arrays. 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public abstract class ThreeByThreeFilter implements Filter {

    //fields
    /**
     * This field holds the weights for the surrounding pixels in the following 
     * manner where the below is the pixel layout and the following is an array
     * of weights.
     * Layout:
     * [0 1 2]
     * [3 4 5]
     * [6 7 8]
     * Array:
     * [0, 1, 2, 3, 4, 5, 6, 7, 8]
     */
    protected int[] weights;
    
    
    /**
     * This array holds onto the current surrounding pixels being used for calculation
     */
    private Pixel[] surrounding;
    
    //constructor
    /**
     * This constructor initializes the current array to a Pixel[] of capacity 9
     */
    public ThreeByThreeFilter(){
        surrounding = new Pixel[9];
    }
    
    //methods
    /**
     * This method provides the general calculating algorithm for the four three 
     * by three filters, calculating the color of a given pixel from the values 
     * of itself and its surroundings.
     * @param theImage the PixelImage to be filtered
     */
    public void filter(PixelImage theImage) {
        //get the image data
        Pixel[][] data = theImage.getData();
        
        //hold onto output data (makes sure to be the same size and have edges)
        Pixel[][] output = theImage.getData();
        
        //start at one and end before minus one to leave the edges unchanged
        for (int row = 1; row < theImage.getHeight() - 1; row++){
            for (int col = 1; col < theImage.getWidth() - 1; col++){
                
                //load in surrounding pixel square
                getSurrounding(data, row, col);
                
                //hold onto calculated color values
                int[] tempRGB = new int[3];
                
                //iterate through colors and calculate values
                for (int color = 0; color < 3; color++){
                    tempRGB[color] = calculateWeight(color);
                }
                
                //give output Pixel[][] the new pixel value
                output[row][col] = new Pixel(tempRGB[0], tempRGB[1], tempRGB[2]);
            }
        }
        
        //set the image to resultant output values
        theImage.setData(output);
    }
    
    /**
     * This method loads in the surrounding pixel square to the surrounding field
     * @param data The Pixel[][] of the working image
     * @param row The row the center pixel is in
     * @param col The column the center pixel is in
     */
    private void getSurrounding(Pixel[][] data, int row, int col){
        //hold onto index in surrounding
        int count = 0;
        
        //iterate through values to add to row and col
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                surrounding[count] = data[row + i][col + j];
                count++;
            }
        }
    }
    
    /**
     * This method calculates the int value of a specified color for the middle 
     * pixel in the surrounding array, using the weights specified in the weight 
     * array.
     * @param color The color to tabulate the weight of where 0 = red, 1 = green, and 2 = blue.
     * @return the weight of the specified color for the middle pixel
     */
    private int calculateWeight(int color) {
        if (color < 0 || color > 2) throw new IllegalArgumentException("invalid color");
        
        //initialize the result, using a double to avoid truncation
        double result = 0;
        
        //iterate through weights and surrounding pixel color values, multiply them and add to result
        for (int i = 0; i < 9; i++) {
            result += surrounding[i].rgb[color] * weights[i];
        }
        
        //divide by the divisor to put the value in range
        result /= getDivisor();
        
        //adjust for boundaries
        if (result > 255) {
            result = 255;
        } else if (result < 0) {
            result = 0;
        }
        
        //cast to int for return
        return (int) result;
    }
    
    /**
     * This method calculates the value to divide by to scale the color value
     * @return the divisor of the weight array 
     */
    private int getDivisor(){
        int sum = 0;
        
        //total up the weights
        for (int i : weights) {
            sum += i;
        }
        
        //avoid dividing by zero
        if (sum == 0) sum = 1;
        return sum;
    }
    
}
