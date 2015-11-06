package hoppeHW6;

/**
 * Class Life is the model (data structure) that holds and updates the
 * status of our cellular automaton game.  It provides methods to initialize
 * the game (done automatically when the game is first created), update one generation
 * and access the game status, which can be used by client code to display
 * the game board and the state of the game
 * 
 * @author  Barbara Goldner, based on work by Hal Perkins
 */
public class Life {
    // public constants

    /** Number of rows/columns in Life Grid  */
    public static final int NROWSCOLS = 19; 

    /** Dead cell */
    public static final boolean DEAD = false;

    /** Alive cell */ 
    public static final boolean ALIVE = true; 


    // private instance variables
    private boolean[][] board;      // game board
    private int generations;   // how many generations have happened


    /** Construct and initialize new game board
     */
    public Life() {
        board = new boolean[NROWSCOLS][NROWSCOLS];
        newGame();
    }

    /** Initialize new game */
    public void newGame() {                    
        for (int r = 0; r < NROWSCOLS; r++){   //reset all to dead first
            for (int c = 0; c < NROWSCOLS; c++){
                board[r][c] = DEAD;
            }
        }
        pulsingSquares(1, 1);
        tetrisBlinker(13, 13);
        glider(14, 1);
        beacon(1, 13);
        staticSquare(6, 15);
        carat(1, 1);
    }
    
    //Following private methods are parts of the newGame call
    private void pulsingSquares(int x, int y){ //a pulsing pattern, top left at x, y
        board[y + 5][x + 2] = ALIVE;
        board[y + 6][x + 2] = ALIVE;
        board[y + 7][x + 2] = ALIVE;
        board[y + 5][x + 3] = ALIVE;
        board[y + 6][x + 3] = ALIVE;
        board[y + 7][x + 3] = ALIVE;
        board[y + 5][x + 4] = ALIVE;
        board[y + 6][x + 4] = ALIVE;
        board[y + 7][x + 4] = ALIVE;
        board[y + 2][x + 5] = ALIVE;
        board[y + 3][x + 5] = ALIVE;
        board[y + 4][x + 5] = ALIVE;
        board[y + 2][x + 6] = ALIVE;
        board[y + 3][x + 6] = ALIVE;
        board[y + 4][x + 6] = ALIVE;
        board[y + 2][x + 7] = ALIVE;
        board[y + 3][x + 7] = ALIVE;
        board[y + 4][x + 7] = ALIVE;
    }
    
    private void tetrisBlinker(int x, int y){ //centered on x, y
        board[y][x] = ALIVE;
        board[y + 1][x] = ALIVE;
        board[y][x + 1] = ALIVE;
        board[y][x - 1] = ALIVE;
    }
    
    private void glider(int x, int y){ //top left at x, y
        board[y][x] = ALIVE;
        board[y + 1][x] = ALIVE;
        board[y + 2][x] = ALIVE;
        board[y + 2][x - 1] = ALIVE;
        board[y + 1][x - 2] = ALIVE;
    }
        
    private void beacon(int x, int y){ //top left at x, y
        board[y][x] = ALIVE;
        board[y + 1][x] = ALIVE;
        board[y][x + 1] = ALIVE;
        board[y + 2][x + 3] = ALIVE;
        board[y + 3][x + 3] = ALIVE;
        board[y + 3][x + 2] = ALIVE;
    }
    
    private void staticSquare(int x, int y){ //top left at x, y
        board[y][x + 1] = ALIVE;
        board[y + 1][x] = ALIVE;
        board[y][x] = ALIVE;
        board[y + 1][x + 1] = ALIVE;
    }
    
    private void carat(int x, int y){
        board[y][x] = ALIVE;
        board[y + 1][x + 1] = ALIVE;
        board[y][x + 2] = ALIVE;
    }
    
    /** Return number of generations */
    public int getGenerationCount() {
        return generations;
    }

    /** Return state of game board cell at given row/column
     *  (Squares numbered from 0 to NROWSCOLS-1). 
     *  @throws IllegalArgumentException for bad row/col */
    public boolean getCell(int row, int col) {
       if (row < 0 || row > NROWSCOLS - 1 || col < 0 || col > NROWSCOLS - 1)
           throw new IllegalArgumentException(); //make sure its a legal cell
       return board[row][col];
    }
    

    /** Process one life cycle of the cellular automaton
     * 
     */
    public void lifeCycle() {
        boolean[][] next = new boolean[NROWSCOLS][NROWSCOLS]; //to store the next iteration
        for (int r = 0; r < NROWSCOLS; r++){
            for (int c = 0; c < NROWSCOLS; c++){  //Default reset to dead
                next[r][c] = DEAD;
            }
        }
        for (int r = 1; r < NROWSCOLS - 1; r++){     //iterating along the cells NOT on the edge
            for (int c = 1; c < NROWSCOLS - 1; c++){
                int count = 0;                       //accumulator
                for (int i = 0; i < 3; i++){         //iterating along the 3 x 3 square containing the 
                    for (int j = 0; j < 3; j++){     //previously specified cell board[c][r]
                        if(board[r - 1 + i][c - 1 + j] == ALIVE) count++;  //counting alive cells
                    }
                }
                if(board[r][c] == DEAD && count == 3) //count excludes the center, because it's dead
                    next[r][c] = ALIVE;               //represents a birth
                else if(board[r][c] == ALIVE && (count < 3 || count > 4)) //count includes the center, since it's alive
                    next[r][c] = DEAD;                //represents loneliness or overcrowding
                else if(board[r][c] == ALIVE)
                    next[r][c] = ALIVE;               //represents survival
                //else do nothing, because the cell remains dead and next defaults to dead. 
            }
        }
        //apply the next generation!
        board = next;
    }

}
