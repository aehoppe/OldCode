package csc143.test.sudoku;

import java.awt.event.*;
import javax.swing.*;
import csc143.sudoku.*;

public class SudokuTest3a {
    
    public SudokuTest3a() {
        twoByTwo();
        twoByThree();
        threeByThree();
        threeByFour();
    }

    public void twoByTwo() {
        JFrame win = new JFrame("2x2 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase board = new SudokuModel(2, 2);
        board.setValue(0, 2, 3);
        board.setValue(1, 2, 1);
        board.setValue(2, 1, 1);
        board.setValue(3, 1, 4);
        board.fixGivens();
        board.setValue(0, 0, 1);
        board.setValue(3, 3, 1);
        SudokuView view = new SudokuView(board);
        view.setSelected(1, 1);
        win.add(view);
        win.setVisible(true);
        win.pack();
    }
    
    public void twoByThree() {
        JFrame win = new JFrame("2x3 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase board = new SudokuModel(2, 3);
        SudokuView view = new SudokuView(board);
        board.setValue(0, 3, 6);
        board.setValue(0, 5, 1);
        board.setValue(1, 2, 4);
        board.setValue(1, 4, 5);
        board.setValue(1, 5, 3);
        board.setValue(2, 3, 3);
        board.setValue(3, 2, 6);
        board.setValue(4, 0, 2);
        board.setValue(4, 1, 3);
        board.setValue(4, 3, 1);
        board.setValue(5, 0, 6);
        board.setValue(5, 2, 1);
        board.fixGivens();
        board.setValue(1, 0, 6);
        board.setValue(3, 1, 5);
        view.setSelected(1, 1);
        win.add(view);
        win.setVisible(true);
        win.pack();
    }
    
    public void threeByThree() {
        JFrame win = new JFrame("3x3 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase board = new SudokuModel(3, 3);
        board.setValue(0, 1, 4);
        board.setValue(0, 2, 1);
        board.setValue(0, 4, 7);
        board.setValue(0, 6, 8);
        board.setValue(0, 7, 9);
        board.setValue(1, 3, 6);
        board.setValue(1, 4, 4);
        board.setValue(1, 5, 1);
        board.setValue(2, 2, 7);
        board.setValue(2, 6, 1);
        board.setValue(3, 1, 7);
        board.setValue(3, 3, 5);
        board.setValue(3, 4, 8);
        board.setValue(3, 5, 3);
        board.setValue(3, 7, 1);
        board.setValue(4, 0, 4);
        board.setValue(4, 1, 5);
        board.setValue(4, 3, 7);
        board.setValue(4, 5, 2);
        board.setValue(4, 6, 8);
        board.setValue(4, 8, 9);
        board.setValue(5, 1, 1);
        board.setValue(5, 3, 4);
        board.setValue(5, 4, 9);
        board.setValue(5, 5, 6);
        board.setValue(5, 7, 2);
        board.setValue(6, 2, 3);
        board.setValue(6, 6, 6);
        board.setValue(7, 3, 1);
        board.setValue(7, 4, 5);
        board.setValue(7, 5, 7);
        board.setValue(8, 1, 9);
        board.setValue(8, 2, 5);
        board.setValue(8, 4, 6);
        board.setValue(8, 6, 7);
        board.setValue(8, 7, 4);
        board.fixGivens();
        SudokuView view = new SudokuView(board);
        board.setValue(4, 4, 1);
        board.setValue(7, 2, 4);
        board.setValue(6, 5, 4);
        board.setValue(2, 8, 4);
        board.setValue(3, 6, 4);
        board.setValue(7, 6, 9);
        board.setValue(6, 3, 9);
        board.setValue(2, 5, 9);
        board.setValue(6, 0, 7);
        board.setValue(5, 8, 7);
        board.setValue(1, 7, 7);
        view.setSelected(1, 1);
        win.add(view);
        win.setVisible(true);
        win.pack();
    }
    
    public void threeByFour() {
        JFrame win = new JFrame("3x4 Board");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SudokuBase board = new SudokuModel(3, 4);
        SudokuView view = new SudokuView(board);
        board.setValue(0, 0, 1);
        board.setValue(0, 2, 12);
        board.setValue(0, 9, 8);
        board.setValue(1, 2, 3);
        board.setValue(1, 6, 12);
        board.setValue(1, 7, 11);
        board.setValue(1, 10, 7);
        board.setValue(2, 1, 7);
        board.setValue(2, 4, 8);
        board.setValue(2, 5, 9);
        board.setValue(2, 6, 10);
        board.setValue(2, 7, 1);
        board.setValue(2, 9, 12);
        board.setValue(3, 1, 9);
        board.setValue(3, 3, 1);
        board.setValue(3, 4, 4);
        board.setValue(3, 7, 5);
        board.setValue(3, 9, 7);
        board.setValue(3, 11, 2);
        board.setValue(4, 1, 8);
        board.setValue(4, 4, 11);
        board.setValue(4, 5, 1);
        board.setValue(4, 10, 10);
        board.setValue(4, 11, 6);
        board.setValue(5, 1, 5);
        board.setValue(5, 3, 12);
        board.setValue(5, 6, 7);
        board.setValue(5, 8, 9);
        board.setValue(5, 9, 11);
        board.setValue(6, 2, 8);
        board.setValue(6, 3, 10);
        board.setValue(6, 5, 6);
        board.setValue(6, 8, 2);
        board.setValue(6, 10, 4);
        board.setValue(7, 0, 4);
        board.setValue(7, 1, 1);
        board.setValue(7, 6, 3);
        board.setValue(7, 7, 8);
        board.setValue(7, 10, 11);
        board.setValue(8, 0, 5);
        board.setValue(8, 2, 7);
        board.setValue(8, 4, 9);
        board.setValue(8, 7, 2);
        board.setValue(8, 8, 6);
        board.setValue(8, 10, 12);
        board.setValue(9, 2, 9);
        board.setValue(9, 4, 10);
        board.setValue(9, 5, 11);
        board.setValue(9, 6, 1);
        board.setValue(9, 7, 12);
        board.setValue(9, 10, 8);
        board.setValue(10, 1, 11);
        board.setValue(10, 4, 2);
        board.setValue(10, 5, 3);
        board.setValue(10, 9, 4);
        board.setValue(11, 2, 1);
        board.setValue(11, 9, 6);
        board.setValue(11, 11, 10);
        board.fixGivens();
        view.setSelected(1, 1);
        board.setValue(11, 8, 11);
        board.setValue(3, 5, 12);
        board.setValue(4, 8, 12);
        board.setValue(7, 4, 12);
        board.setValue(10, 11, 12);
        win.add(view);
        win.setVisible(true);
        win.pack();
    }
    
    public static void main(String[] args) {
        new SudokuTest3a();
    }
    
}