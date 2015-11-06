package csc143.la9;

import java.awt.*;
import javax.swing.*;

/**
 * Testing code for Learning Activity: Graphics
 *
 * @author Dan
 * @version 0.5
 */
public class GraphicsLA {

  /**
   * The driver that creates two X2 instances and
   * two O2 instances and places them in a window.
   * @param args The command-line arguments, ignored
   */
  public static void main(String[] args) {
      
    // setup the window
    JFrame win = new JFrame("Test Component");
    win.setSize(400, 300);
    win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // create the first component, X2 with default colors
    X2 x = new X2();
    win.add(x, BorderLayout.NORTH);

    // create the second component, O2 with default colors
    O2 o = new O2();
    win.add(o, BorderLayout.SOUTH);

    // create the third component, O2 with custom color
    o = new O2();
    o.setLineColor(Color.red);
    o.setFillColor(Color.yellow);
    win.add(o, BorderLayout.WEST);

    // create the fourth component, X2 with custom color
    x = new X2();
    x.setLineColor(Color.blue);
    win.add(x, BorderLayout.EAST);

    // show the window
    win.setVisible(true);

    // pause the application
    JOptionPane.showMessageDialog(win, "Click OK to continue");

    // change the layout
    win.setLayout(new GridLayout(2, 2));
    // force the new layout manager to work
    win.validate();

  }
}