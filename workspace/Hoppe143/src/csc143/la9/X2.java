package csc143.la9;

import java.awt.*;

/**
 * A sample component class that draws an X with the specified color
 * @author Dan Jinguji
 * @author Alexander Hoppe
 * @version May 28 2015
 */
@SuppressWarnings("serial")
public class X2 extends javax.swing.JComponent {
    
    //fields
    /**
     * This field holds onto the line color
     */
    private java.awt.Color lc;
    
    //methods
  
    /**
     * Default constructor, sets the preferred size.
     */
    public X2() {
        this(Color.BLACK);
    }
    
    /**
     * Parameterized constructor for internal use, sets line color
     * @param lineColor The desired line color
     */
    X2(Color lineColor) {
        setPreferredSize(new Dimension(25, 25));
        lc = lineColor;
    }
    
    /**
     * The necessary method. This method
     * renders the component.
     * @param g The Graphics object use to render
     */
    public void paintComponent(java.awt.Graphics g) {
        // paint the background
        super.paintComponent(g);
        // draw the two lines
        g.setColor(lc);
        g.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawLine(0, getHeight() - 1, getWidth() - 1, 0);
    }
    
    /**
     * Getter for line color
     * @return The color of the line
     */
    public java.awt.Color getLineColor() {
        return lc;
    }
    
    /**
     * Setter for line color
     * @param rgb The color of the line
     */
    public void setLineColor(java.awt.Color rgb) {
        lc = rgb;
        repaint();
    }
}
