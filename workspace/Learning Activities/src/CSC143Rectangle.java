/**
 * Simple shape class, an abstraction of a rectangle.
 * 
 * @author Dan
 * @version 3 May 2011
 */
public class CSC143Rectangle extends CSC143Shape {
   
   /**
    * Create a rectangle.
    * @param h The height of the rectangle
    * @param w The width of the rectangle
    */
   public CSC143Rectangle(int h, int w) {
      super(h, w);
   }
   
   /**
    * Get the width of the rectangle object.
    * @return the width of the rectangle
    */
   public int getWidth() {
      return super.getWidth();
   }
   
   /**
    * Get the height of the rectangle object.
    * @return the height of the rectangle
    */
   public int getHeight() {
      return super.getHeight();
   }
   
   /**
    * Returns the area of the rectangle object.
    * @return the area of the rectangle object
    */
   public double getArea() {
      return getHeight() * getWidth();
   }
   
}