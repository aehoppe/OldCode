package csc143.sudoku;

import java.awt.*;

/**
 * This class implements the SymbolRenderer interface with number symbols
 * @author Alexander Hoppe
 * @version May 31, 2015
 */
public class NumberSymbols implements SymbolRenderer {

    /**
     * This method renders int values into graphical symbols
     * @param g The Graphics object being used
     * @param x The x value of the rendered symbol
     * @param y The y value of the rendered symbol
     * @param value The int value corresponding to the symbol to be rendered
     */
    @Override
    public void drawSymbol(Graphics g, int x, int y, int value) {
        //make the line thick
        ((Graphics2D) g).setStroke(new BasicStroke(4));
        //set clip so it doesn't go out of bounds
        ((Graphics2D) g).setClip(x, y, 40, 40);
        //the different cases
        switch(value) {
        case 0: //draw nothing
            break;
        case 1: //draw a one
            g.drawLine(x + 2, y + 17, x + 19, y);
            g.drawLine(x + 20, y, x + 20, y + 40);
            g.drawLine(x, y + 38, x + 40, y + 38);
            break;
        case 2: //draw a two
            g.drawArc(x + 2, y + 2, 36, 20, -20, 195);
            g.drawLine(x + 38, y + 15, x, y + 38);
            g.drawLine(x, y + 38, x + 38, y + 38);
            break;
        case 3: //draw a three
            g.drawArc(x + 2, y + 2, 36, 18, -90, 235);
            g.drawArc(x + 2, y + 20, 36, 18, 90, -235);
            break;
        case 4: //draw a four
            g.drawLine(x + 2, y + 26, x + 28, y);
            g.drawLine(x + 30, y, x + 30, y + 40);
            g.drawLine(x, y + 28, x + 40, y + 28);
            break;
        case 5: //draw a five
            g.drawLine(x, y + 2, x + 40, y + 2);
            g.drawLine(x + 2, y, x + 2, y + 20);
            g.drawArc(x, y + 16, 38, 22, 135, -280);
            break;
        case 6: //draw a six
            g.drawArc(x + 2, y + 2, 50, 50, 90, 90);
            g.drawArc(x + 2, y + 18, 36, 20, 0, 360);
            break;
        case 7: //draw a seven
            g.drawLine(x, y + 2, x + 38, y + 2);
            g.drawLine(x + 38, y + 2, x, y + 40);
            break; 
        case 8: //draw an eight
            g.drawOval(x + 2, y + 2, 36, 18);
            g.drawOval(x + 2, y + 20, 36, 18);
            break;
        case 9: //draw a nine
            g.drawArc(x + 2, y + 2, 36, 20, 0, 360);
            g.drawLine(x + 38, y + 10, x + 38, y + 38);
            break;
        case 10: //draw a ten
            g.drawLine(x + 5, y, x + 5, y + 40);
            g.drawLine(x + 4, y, x , y + 4);
            g.drawLine(x, y + 38, x + 9, y + 38);
            g.drawOval(x + 11, y + 2, 27, 36);
            break;
        case 11: //draw an eleven
            g.drawLine(x + 12, y, x + 12, y + 40);
            g.drawLine(x + 11, y, x + 2, y + 9);
            g.drawLine(x + 3, y + 38, x + 19, y + 38);
            g.drawLine(x + 30, y, x + 30, y + 40);
            g.drawLine(x + 29, y, x + 20, y + 9);
            g.drawLine(x + 21, y + 38, x + 37, y + 38);
            break;
        case 12: //draw a twelve
            g.drawLine(x + 12, y, x + 12, y + 40);
            g.drawLine(x + 11, y, x + 2, y + 9);
            g.drawLine(x, y + 38, x + 40, y + 38);
            g.drawLine(x + 22, y + 38, x + 38, y + 10);
            g.drawArc(x + 20, y + 2, 18, 15, -20, 195);
            break;
        }
        
        ((Graphics2D) g).setStroke(new BasicStroke(0));
    }
    
    public static void main(String[] args) {
        new csc143.test.sudoku.SudokuTest1b().testSymbols(new NumberSymbols());
    }

}
