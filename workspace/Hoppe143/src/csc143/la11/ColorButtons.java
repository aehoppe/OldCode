package csc143.la11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ColorButtons {
    
    private JPanel panel;
    
//    private Color[] colors = {Color.red, Color.green, Color.blue,
//        Color.cyan, Color.magenta, Color.yellow, Color.black,
//        Color.white};
    private Color[] rgb = {Color.red, Color.green, Color.blue};
    private Color[] cmyk = {Color.cyan, Color.magenta, Color.yellow, Color.black};
    
    public ColorButtons() {
        // set up the window
        JFrame win = new JFrame("Color Buttons");
        win.setSize(560, 420);
        win.setLocation(50, 50);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // set up the toolbar
        JPanel tool = new JPanel();
        
        //add rgb buttons
        for(int i = 0; i < rgb.length; i++) {
            tool.add(new ColorButton(rgb[i]));
        }
        //add cmyk buttons
        for(int i = 0; i < cmyk.length; i++) {
            tool.add(new ColorButton(cmyk[i]));
        }
        //add white button
        tool.add(new ColorButton(Color.WHITE));
        win.add(tool, BorderLayout.NORTH);
        
        // set up the display area
        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        win.add(panel);
        
        win.setVisible(true);
    }
    
    public static void main(String[] args) {
        new ColorButtons();
    }
    

    
    //class for the buttons
    class ColorButton extends JPanel {
        //constructor
        public ColorButton(Color c) {
            setBackground(c);
            setPreferredSize(new Dimension(50, 50));
            this.addMouseListener(new colorSwitch(c));
        }
        
        //helper class for clicks
        private class colorSwitch extends MouseAdapter {

            //reusability
            private Color color;

            //again, reusability
            private colorSwitch(Color c) {
                color = c;
            }
            
            //the actual listener part
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setBackground(color);
            }
        }
    }
}

