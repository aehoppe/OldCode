package csc143.test.sudoku;

import javax.swing.*;
import csc143.sudoku.*;

public class SudokuTest1a {
    
    public SudokuTest1a() {
        twoByTwo();
        twoByThree();
        threeByTwo();
        threeByThree();
        threeByFour();
    }

    public void twoByTwo() {
        JFrame win = new JFrame("2x2 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase base = new SudokuStub(2, 2);
        SudokuBoard board = new SudokuBoard(base);
        win.add(board);
        win.setVisible(true);
        win.pack();
    }
    
    public void twoByThree() {
        JFrame win = new JFrame("2x3 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase base = new SudokuStub(2, 3);
        SudokuBoard board = new SudokuBoard(base);
        win.add(board);
        win.setVisible(true);
        win.pack();
    }
    
    public void threeByTwo() {
        JFrame win = new JFrame("3x2 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase base = new SudokuStub(3, 2);
        SudokuBoard board = new SudokuBoard(base);
        win.add(board);
        win.setVisible(true);
        win.pack();
    }
    
    public void threeByThree() {
        JFrame win = new JFrame("3x3 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase base = new SudokuStub(3, 3);
        SudokuBoard board = new SudokuBoard(base);
        win.add(board);
        win.setVisible(true);
        win.pack();
    }
    
    public void threeByFour() {
        JFrame win = new JFrame("3x4 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase base = new SudokuStub(3, 4);
        SudokuBoard board = new SudokuBoard(base);
        win.add(board);
        win.setVisible(true);
        win.pack();
    }
    
    public static void main(String[] args) {
        new SudokuTest1a();
    }
    
}