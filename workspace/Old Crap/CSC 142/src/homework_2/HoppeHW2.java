package homework_2;

import java.awt.*;

/**
 * This class makes two DrawingPanels with different figures on them. The first
 * is three overlapping colored squares, and the second is a series of cafe-wall
 * illusions
 * 
 * note: the second DrawingPanel offsets everything to the right five pixels. 
 * I cannot solve it any way, even if I try to draw in that space it cuts off. 
 * My coordinates are 0, and it doesn't go.
 * 
 * @author Alexander Hoppe
 * @version 10/8/14
 */
public class HoppeHW2 {

    /**
     * This constant is the spacing between columns in the cafe wall
     */
    public static final int MORTAR = 2;

    static Color xcolor = Color.ORANGE;

    public static void main(String[] args){
        //draw a pattern
        //draw the cafe wall pattern to specs
        drawFirstFigure();
        drawCafeWallImage();
    }
    /**
     * This method draws a square with a top left corner at (xpos,ypos) with 
     * sides of length side and of color color.
     * @param g The graphics object to be used
     * @param xpos The x position of the square
     * @param ypos The y position of the square
     * @param sideLength The side length of the square
     * @param color The color of the square
     */
    public static void drawSquare(Graphics g, int xpos, int ypos, int sideLength, Color color){
        g.setColor(color);
        g.fillRect(xpos, ypos, sideLength, sideLength);
    }
    /**
     * This method initializes a DrawingPanel object, initializes a Graphics 
     * object, and draws three squares in a diagonal line, a blue, a white, and 
     * a red square. It also displays my name 
     */
    public static void drawFirstFigure(){
        DrawingPanel dp1 = new DrawingPanel(150,150);
        dp1.setBackground(Color.LIGHT_GRAY);
        Graphics gfirst = dp1.getGraphics();
        drawSquare(gfirst, 0, 0, 100, Color.WHITE);
        drawSquare(gfirst, 0, 0, 30, Color.RED);
        drawSquare(gfirst, 20, 20, 30, Color.GREEN);
        drawSquare(gfirst, 40, 40, 30, Color.BLUE);
        String myname = "Alexander Hoppe";           //declaring a string with my name
        gfirst.setColor(Color.BLACK);
        gfirst.drawString(myname, 0, 95);
    }
    /**
     * This method draws the cafe wall figure from the assignment by initializing
     * a second drawing panel and calling the methods to draw columns and sets of
     * column pairs (tile patterns). 
     */
    public static void drawCafeWallImage(){
        DrawingPanel dp2 = new DrawingPanel(800,700);
        dp2.setBackground(Color.LIGHT_GRAY);
        Graphics gsecond = dp2.getGraphics();
        drawColumn(gsecond, 0, 0, 20, 6);             //drawing columns
        drawColumn(gsecond, 700, 220, 50, 4); 
        drawTilePattern(gsecond, 30, 580, 10, 4, 0);  //drawing cafe walls
        drawTilePattern(gsecond, 600, 15, 25, 3, 15);
        drawTilePattern(gsecond, 150, 150, 40, 5, 10);
    }
    /**
     * This method draws one of the café wall tiles with the specified details
     * @param g The graphics object with which we draw the tile
     * @param xpos The x coordinate of the top left corner
     * @param ypos The y coordinate of the top left corner
     * @param sideLength The side length of one of the squares in the tile
     */
    public static void drawTile(Graphics g, int xpos, int ypos, int sideLength){
        drawSquare(g, xpos, ypos, sideLength, Color.BLUE);
        drawSquare(g, xpos, ypos + sideLength, sideLength, Color.WHITE);
        g.setColor(xcolor);
        g.drawLine(xpos, ypos, xpos + sideLength, ypos + sideLength);
        g.drawLine(xpos + sideLength, ypos, xpos, ypos + sideLength);
    }
    /**
     * This method draws a column of tiles, using the drawTile method.
     * @param g The graphics object
     * @param xpos The x coordinate of the top left corner
     * @param ypos The y coordinate of the top left corner
     * @param sideLength The width of the tiles
     * @param height The height in tiles of the column
     */
    public static void drawColumn(Graphics g, int xpos, int ypos, int sideLength,
            int height){
        for (int i = 0; i < height; i++){
            drawTile(g, xpos, ypos + (i * 2 * sideLength), sideLength);  // this draws the column
        } 
    }
    /**
     * This method draws a pair of columns at the x and y coordinates specified,
     * of a specified height, where the second column is offset from the first.
     * This method calls the drawColumn method to make the two columns 
     * @param g  This is the graphics object to draw with
     * @param xpos This is the x coordinate of the top left corner
     * @param ypos This is the y coordinate of the top left corner
     * @param height This is the height of the column pair, in tiles
     * @param offset This is the y-offset of the second column
     */
    public static void drawColumnPair(Graphics g, int xpos, int ypos, int sideLength,
            int height, int offset){
        drawColumn(g, xpos, ypos, sideLength, height);
        drawColumn(g, xpos + sideLength + MORTAR, ypos + offset, sideLength, height);
    }
    /**
     * This method constructs a café wall illusion using tiles, to the specs
     * provided in the parameters. It calls the drawColumnPair method and 
     * draws the columns next to each other.
     * @param g The graphics object to draw the cafe wall with
     * @param xpos The x coordinate of the top left corner of the whole cafe
     * wall pattern
     * @param ypos The y coordinate of the top left corner
     * @param sideLength The side length of the squares that make up each tile, also
     * the width of each column (not including mortar)
     * @param pairNum the number of column pairs AND the height of those pairs
     * @param offset The height offset between alternating columns of the pattern
     */
    public static void drawTilePattern(Graphics g, int xpos, int ypos, int sideLength, 
            int pairNum, int offset){
        for (int i = 0; i < pairNum; i++){
            drawColumnPair(g, xpos + 2 * (i * sideLength + i * MORTAR), ypos, 
                    sideLength, pairNum, offset);
        }
    }
}

