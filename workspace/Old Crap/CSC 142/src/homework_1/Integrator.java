package homework_1;

/**
 * This class estimates the integral of a curve using rectangles.
 * I got debug advice from Miles Baker.
 * @author Alexander Hoppe
 * @version 9/30/14
*/

public class Integrator {
	
	/**
	 * This is the number of estimations the program makes of the area,
	 * corresponding to 2 ** i + 1 estimation rectangles 
	 */
	public static final int ESTIMATIONS = 15;
	
	/**
	 * This is the range of the function being integrated
	 */
	public static final double RANGE = 4;
	
	
	public static void main(String[] args) {
		for (int i = 1; i <= ESTIMATIONS; i++){                     //output loop
			System.out.print("Using " + ((int) Math.pow(2, i) + 1) + " rectangles, the estimated area is ");
			System.out.println(curveArea((int) Math.pow(2, i) + 1));
		}
	}	
	
	/**
	 * This method calculates the area of all the rectangles under the curve
	 * @param rectangles is the number of rectangles used to estimate the area
	 * @return accumulated area under the curve as a double less than pi
	 */
	public static double curveArea (int rectangles){
		double width = RANGE / rectangles;
		double area = 0;
		for (double j = 0; j < 4; j += width){                        //accumulates area
			area += rectArea(width, height(j));
		}
		return area;
	}
	
	/**
	 * This method calculates the area of a rectangle
	 * @param width is the width of the box
	 * @param height is the height of the box
	 * @return rectangle area as a double
	 */
	public static double rectArea (double width, double height){
		return width * height;
	}
	
	/**
	 * This method calculates the height of the curve at any x position
	 * @param xpos is the x position on the curve
	 * @return height of the curve at x as a double between 0 and 4
	 */
	public static double height(double xpos){
		return (Math.sqrt(4 * xpos - xpos * xpos))/2; // This is where the equation from the assignment comes in. 
	}
}
