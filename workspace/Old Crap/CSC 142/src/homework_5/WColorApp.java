package homework_5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * Provides a GUI interface to allow a user to read in a file of WeightedColors,
 * and get interesting stats
 * 
 * You are not responsible for understanding this code, but if you have any questions,
 * I'd be happy to answer them.
 * 
 * @author csc142 
 * @version Spring 2012
 */
public class WColorApp
{
    private JTextArea text; 
    
    /**
     * Constructor for objects of class GPSApp
     */
    public WColorApp()
    {
        JFrame win = new JFrame("142 Weighted Colors");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500, 400);
        
        // Create the button 
        JButton button = new JButton("Load File");
        
        // put button in a panel and then into the frame
        JPanel back = new JPanel();
        back.setBackground(Color.blue);
        back.add(button);
        win.getContentPane().add(back,BorderLayout.SOUTH );
        
        // now set up the event handler
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                process();
            }
            
        });
        
        // create the display area and place it
        text = new JTextArea();
        JScrollPane scrolltxt = new JScrollPane(text);
        win.getContentPane().add(scrolltxt, BorderLayout.CENTER);
        
        // get the frame ready to show
        win.validate();
        win.setVisible(true);
        win.toFront();
    }
    
    // processing the button click
    private void process(){
        
        // get filename from user
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION){
            String filename = fc.getSelectedFile().getName();
            
            // create a LocationSet and display results
            try {
                WColorSet cs = new WColorSet(new File(filename));
                String results = buildDisplay(cs);
                text.setText("File:\t" + filename + "\n\n");
                text.append(results);
            } catch (FileNotFoundException e){
                text.setText("Sorry, file not found\nPlease try again");
            }catch (Exception e) {
                text.setText(e.toString());
            }
        } 
    }
    
    // build & return String for display using information from ls
    private String buildDisplay(WColorSet wcs) {
        String output = "";
        
        double[] brightVals = wcs.getBrightness();
        WeightedColor[] seq = wcs.getNonDecSeq();
        
        output += "Number of weighted colors =  " + wcs.getCount() + '\n';
        output += "Weighted brightness    =  " + wcs.calculate() + '\n';
        output += "Weight Change          = "  + wcs.weightChange() + "\n\n";
        
        output += "Brightness values\n";
        output += createString(brightVals);
        output += "---------------------------------------\n";
        output += "Longest non-decreasing sequence of brightness\n";
        output += createString(seq);
        return output;
    }
    
    private static String createString(double[] a){
        String out = "";
        for (double x  : a)
           out += x + "\n";
        return out + '\n';
    }
       
    private static String createString(WeightedColor[] a){
        String out = "";
        for (WeightedColor x  : a)
           out += x + "\tbrightness = " + x.getBrightness() + "\n";
        return out + '\n';
    }

    public static void main(String [] args) {
         //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WColorApp b = new WColorApp();
            }
        });
    }

}
