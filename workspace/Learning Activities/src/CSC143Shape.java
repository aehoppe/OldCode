/**
 * Simple shape class, an abstraction of a shape, the base class.
 * 
 * @author Dan
 * @version 3 May 2011
 */
public abstract class CSC143Shape {

   // fields to maintain size information   
   private int width;
   private int height;

   /**
    * Create a shape.
    * @param w The width of the shape
    * @param h The height of the shape
    */
   public CSC143Shape(int w, int h) {
      if(w<0 || h<0) 
         throw new IllegalArgumentException("Dimensions cannot be negative");
      if(w>1000 || h>1000) 
         throw new IllegalArgumentException("Dimensions cannot be greater than 1,000");
      width = w;
      height = h;
   }
   
   /**
    * Get the width of the shape object.
    * @return the width of the shape 
    */
   protected int getWidth() {
      return width;
   }
   
   /**
    * Get the height of the shape object.
    * @return the height of the shape 
    */
   protected int getHeight() {
      return height;
   }
   
   /**
    * Returns the area of the shape object.
    * @return the area of the shape object
    */
   public abstract double getArea();
   
}