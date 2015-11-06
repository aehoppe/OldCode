package csc143.demo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MovingDot extends JPanel implements Runnable {
    
    private int x, y;
    
    public MovingDot() {
        x = 0;
        y = 0;
        setBackground(Color.white);
        addMouseListener (new Mousie());
    }
    
    public void moveRight() {
        while(x + 100 < getWidth()) {
            x += 10;
            repaint();
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillOval(x, y, 100, 100);
    }
    
    @Override
    public void run() {
        moveRight();
    }
    
    class Mousie extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            x = y = 0;
            repaint();
        }
    }
    
    public static void main(String[] args) {
        JFrame win = new JFrame("Moving Dot");
        win.setSize(400, 300);
        win.setLocation(50, 50);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel tools = new JPanel();
        JButton btn = new JButton("Move Right");
        tools.add(btn);
        win.add(tools, BorderLayout.SOUTH);
        MovingDot md = new MovingDot();
        win.add(md); 
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(md);
                t.start();
            }
        });
        win.setVisible(true);
        md.moveRight();
    }
    
}