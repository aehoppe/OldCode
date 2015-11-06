package csc143.test.sudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SudokuTest1b {
    
    private JFrame win;
    private csc143.sudoku.SymbolRenderer sym;
    private JComboBox<String> color;
    private JComboBox<Integer> value;
    private static final Color[] colors = 
    {Color.black, Color.red, Color.green, Color.blue};
    private static final Color bg = new Color(255, 255, 204);
    private static final Color fg = new Color(255, 204, 255);
    
    public void testSymbols(csc143.sudoku.SymbolRenderer s) {
        sym = s;
        win = new JFrame("Symbol checker");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setLocation(50, 50);
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                win.repaint();
            }
        };
        JPanel tools = new JPanel();
        color = new JComboBox<String>();
        color.addItem("black");
        color.addItem("red");
        color.addItem("green");
        color.addItem("blue");
        color.setSelectedIndex(1);
        color.addActionListener(a);
        tools.add(new JLabel("Select color"));
        tools.add(color);
        value = new JComboBox<Integer>();
        for(int i = 0; i < 13; i++) {
            value.addItem(i);
        }
        value.setSelectedIndex(1);
        value.addActionListener(a);
        tools.add(new JLabel("  Select value:"));
        tools.add(value);
        win.add(tools, BorderLayout.SOUTH);
        win.add(new DrawSymbol());
        win.pack();
        win.setVisible(true);
    }
    
    class DrawSymbol extends JPanel {
        DrawSymbol() {
            setPreferredSize(new Dimension(310, 90));
        }
        public void paintComponent(Graphics g) {
            int v = value.getSelectedIndex();
            g.setColor(Color.white);
            g.fillRect(40, 20, 50, 50);
            g.setColor(bg);
            g.fillRect(130, 20, 50, 50);
            g.fillRect(220, 20, 50, 50);
            g.setColor(colors[color.getSelectedIndex()]);
            sym.drawSymbol(g, 45, 25, v);
            sym.drawSymbol(g, 135, 25, v);
            sym.drawSymbol(g, 225, 25, v);
            g.setColor(fg);
            g.fillRect(130, 20, 5, 50);
            g.fillRect(130, 20, 50, 5);
            g.fillRect(175, 20, 5, 50);
            g.fillRect(130, 65, 50, 5);
            g.fillRect(225, 25, 40, 40);
        }
    }
}