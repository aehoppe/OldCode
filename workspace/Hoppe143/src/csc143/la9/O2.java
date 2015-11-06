package csc143.la9;

import java.awt.*;
import javax.swing.*;

/**
 * This class is a sample component that is a circle with line and fill color 
 * properties
 * @author Alexander Hoppe
 * @version May 28, 2015
 */
@SuppressWarnings("serial")
public class O2 extends JComponent {

    //fields
    /**
     * These fields hold onto the line and fill color of the O
     */
    private java.awt.Color lc, fc;
    
    //constructor
    /**
     * This constructor sets the line and fill color to default black and its 
     * preferred size to 25x25
     */
    public O2() {
        this(Color.BLACK, Color.BLACK);
    }
    
    /**
     * Parameterized constructor for internal use, has line and fill color
     * @param fillColor The desired fill color
     * @param lineColor The desired line color
     */
    O2(Color fillColor, Color lineColor) {
        setPreferredSize(new Dimension(25, 25));
        fc = fillColor;
        lc = lineColor;
    }
    
    //methods
    /**
     * This method sets the line color
     * @param c the desired line color
     */
    public void setLineColor(Color c) {
        lc = c;
        repaint();
    }
    
    /**
     * This method returns the line color
     * @return the line color
     */
    public Color getLineColor() {
        return lc;
    }
    
    /**
     * This method sets the fill color
     * @param c the desired fill color
     */
    public void setFillColor(Color c) {
        fc = c;
        repaint();
    }
    
    /**
     * This method returns the fill color
     * @return the current fill color
     */
    public Color getFillColor() {
        return fc;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //paint the background
        super.paintComponent(g);
        //draw the fill
        g.setColor(fc);
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        //draw the line
        g.setColor(lc);
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }
    
    
}
