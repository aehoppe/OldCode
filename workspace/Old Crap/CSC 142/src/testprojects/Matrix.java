package testprojects;

public class Matrix {
    public static int ROW = 3;
    public static int COL = 4;

    // declare the instance variable that will hold the 2-dim array
    private double[][] matrix;

    
    /**Instantiate a ROW x COL matrix, empty
    */
    public Matrix() {
        matrix = new double[COL][ROW];
    }
    
    
    /** set the value of a particular element in the matrix
     * @param row the row of the element. 0 <= row < Matrix.ROW
     * @param col the column of the element.   0 <= col < Matrix.COL
     * @param value the value to be stored
     * @throws IllegalArgumentException if indices are invalid
     */
    public void setValue(int row, int col, double value) {
        // Why don't we have to test row/col for validity?
        if(row < 0 || row >= ROW || col < 0 || col >= COL)
            throw new IllegalArgumentException();
        matrix[col][row] = value;
    }
    
    /** returns the value of a particular element in the matrix
     * @param row the row of the element. 0 <= row < Matrix.ROW
     * @param col the column of the element.   0 <= col < Matrix.COL
     */
    public double getValue(int row, int col) {
        if(row < 0 || row >= ROW || col < 0 || col >= COL)
            throw new IllegalArgumentException();
        return matrix[col][row];
    }
    
    
    /** swap 2 rows of this matrix
     * @param r1 one of the rows to swap.  0 <= r1 < Matrix.ROW
     * @param r2 the other row to swap.   0 <= r2 < Matrix.COL
     */
    public void swapRows(int r1, int r2) {
        double[] temp = new double[COL];
        temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;

    }
    
    /** multiply one row by a non-zero constant
     * @param multiple the non-zero constant
     * @param row the row to change
     * @throws IllegalArgumentException if multiple is 0
     */
    public void multiplyRow(double multiple, int row) {
        if(multiple == 0)
            throw new IllegalArgumentException();
        for(int i = 0; i < COL; i++)
            matrix[i][row] *= multiple;
    }
    
    /** add row r1 into row r2. Equivalent to r2 += r1 
     * @param r1 the row to add  0 <= r1 < Matrix.ROW
     * @param r2 the row to add into.  0 <= r2 < Matrix.ROW.  This row will change.
     */
    public void addRows (int r1, int r2) {
       for(int i = 0; i < COL; i++)
           matrix[i][r2] += matrix[i][r1];
    }
      
    /**
     * set new row in the matrix
     * @param row the new row to insert
     * @param rIdx the index of this new row  0 <= rIdx < Matrix.ROW
     * @return the old row
     * @throws IllegalArgument exception if row is not the correct length of Matrix.COL
     */
      public double[] replace(double[] row, int rIdx){
          if(row.length != COL)
              throw new IllegalArgumentException();
          double[] temp = new double[COL];
          temp = matrix[rIdx];
          matrix[rIdx] = row;
          return temp;
      }
      
    /**
     * Add 2 Matrices together and return a new Matrix
     * @param m the 2nd Matrix
     * @return the matrix sum of this + m
     */
      
      public Matrix sum(Matrix m){
          Matrix result = new Matrix();
          int i, j;
          for(i = 0; i < ROW; i++){
              for(j = 0; j < COL; j++){
                  double sum = this.getValue(i, j) + m.getValue(i, j);
                  result.setValue(i, j, sum);
              }
          }
          return result;
          
      }
      
    
    /** Return this matrix as a String of 3 rows of numbers in 4 columns
     */
    public String toString() {
        int i, j;
        String output = "";
        for(i = 0; i < ROW; i++){
            output += "[ ";
            for(j = 0; j < COL; j++){
                output += matrix[j][i] + " ";
            }
            output += "]\n";
        }
        return output;
    }

}
