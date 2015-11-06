package csc143.test.sudoku;

public class SudokuTest2 {
    
    public static void randomTest(int rows, int cols) {
        
        // create a board of the given layout
        csc143.sudoku.SudokuModel model = new csc143.sudoku.SudokuModel(rows, cols);
        int size = model.getSize();
        
        // put random values into the board
        for(int i = 0; i < size * size; i++) {
            int row = (int)(Math.random() * size);
            int col = (int)(Math.random() * size);
            int value = (int)(Math.random() * (size + 1));
            model.setValue(row, col, value);
        }
        
        // print out the board
        System.out.println("Random board: " + rows + "x" + cols);
        System.out.println(model);
        
        // report state
        for(int i = 0; i < size; i++)
            System.out.println("Row " + i + " state: " + model.getRowState(i));
        for(int i = 0; i < size; i++)
            System.out.println("Column " + i + " state: " + model.getColumnState(i));
        for(int i = 0; i < size; i++)
            System.out.println("Region " + i + " state: " + model.getRegionState(i));
        System.out.println();
        
    }
    
    public static void completeTest() {
        
        // create a 2 x 2 board
        csc143.sudoku.SudokuModel model = new csc143.sudoku.SudokuModel(2, 2);
        
        //add values to make it complete
        model.setValue(0, 0, 1);
        model.setValue(0, 1, 2);
        model.setValue(0, 2, 3);
        model.setValue(0, 3, 4);
        model.setValue(1, 0, 3);
        model.setValue(1, 1, 4);
        model.setValue(1, 2, 1);
        model.setValue(1, 3, 2);
        model.setValue(2, 0, 2);
        model.setValue(2, 1, 1);
        model.setValue(2, 2, 4);
        model.setValue(2, 3, 3);
        model.setValue(3, 0, 4);
        model.setValue(3, 1, 3);
        model.setValue(3, 2, 2);
        model.setValue(3, 3, 1);
        
        //report toString and State
        System.out.println("Complete 2x2 board");
        System.out.println(model);
        
        // report state
        for(int i = 0; i < 4; i++)
            System.out.println("Row " + i + " state: " + model.getRowState(i));
        for(int i = 0; i < 4; i++)
            System.out.println("Column " + i + " state: " + model.getColumnState(i));
        for(int i = 0; i < 4; i++)
            System.out.println("Region " + i + " state: " + model.getRegionState(i));
        System.out.println();
    }
    
    public static void main(String[] args) {
        randomTest(2,2);
        randomTest(2,3);
        randomTest(3,3);
        completeTest();
    }
}