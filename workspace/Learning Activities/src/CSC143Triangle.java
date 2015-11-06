/**
 * Simple shape class, an abstraction of a triangle.
 * 
 * @author Dan
 * @version 3 May 2011
 */
public class CSC143Triangle extends CSC143Shape {
   
   /**
    * Create a triangle.
    * @param b The base of the triangle
    * @param h The height of the triangle
    */
   public CSC143Triangle(int b, int h) {
      super(b, h);
   }
   
   /**
    * Get the base of the triangle object.
    * @return the base of the triangle
    */
   public int getBase() {
      return getWidth();
   }
   
   /**
    * Get the height of the triangle object.
    * @return the height of the triangle
    */
   public int getHeight() {
      return super.getHeight();
   }
   
   /**
    * Returns the area of the triangle object.
    * @return the area of the triangle object
    */
   public double getArea() {
      return getBase() * getHeight() / 2;
   }
   
}