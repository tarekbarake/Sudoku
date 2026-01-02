import java.util.Arrays;

public class SudokuSolver {
    private static final int BOX_SIZE = 3 ;
    public  static final int GRID_BOUNDARY = BOX_SIZE * BOX_SIZE;
    public static boolean isAllowedRow(int[][] board, int row, int number){
        for (int col=0; col< GRID_BOUNDARY; col++){
            if (board[row][col] == number)
                return false;
        }return true;
    }
    public static boolean isAllowedCol(int[][] board, int col, int number){
        for (int row=0;row<GRID_BOUNDARY;row++){
            if (board[row][col] == number)
                return false;
        }
        return true;
    }
    public static boolean isAllowedInOneBox(int[][] board, int col, int row, int number){
        int topLeftCol = col-col%3;
        int topLeftRow = row-row%3;
            // get the row box
            for (int c=topLeftCol;c<topLeftCol+3;c++) {
                // get the column box
                for (int r = topLeftRow; r < topLeftRow+3; r++) {
                    if (board[r][c] == number)
                        return false;
                }
            }
            return true;
    }
    private  static void testValidPlacement (int [][]board,int col, int row, int number){
        System.out.println("does the colums match: "+ isAllowedCol(board,col,number) );
        System.out.println("does the row match: "+ isAllowedRow(board,row,number) );
        System.out.println("does the box match: "+ isAllowedInOneBox(board,col,row,number) );
    }


    static int[][] board = {
            {0, 0, 0, 6, 0, 0, 4, 0, 0},
            {7, 0, 0, 0, 0, 3, 6, 0, 0},
            {0, 0, 0, 0, 9, 1, 0, 8, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 1, 8, 0, 0, 0, 3},
            {0, 0, 0, 3, 0, 6, 0, 4, 5},
            {0, 4, 0, 2, 0, 0, 0, 6, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 1, 0, 0}
    };

    private static boolean isThePlacementCorrect (int [][]board,int col, int row, int number){
        return isAllowedCol(board,col,number) &&
                isAllowedRow(board,row,number) &&
                isAllowedInOneBox(board,col,row,number);
    }

    public static boolean finalSolve(int[][] board, int row, int col) {
        // Base case: if we've filled all rows, puzzle is solved
        if (row == GRID_BOUNDARY) {
            return true;
        }

        // Move to next row if we've finished current row
        if (col == GRID_BOUNDARY) {
            return finalSolve(board, row + 1, 0);
        }

        // Skip cells that are already filled
        if (board[row][col] != 0) {
            return finalSolve(board, row, col + 1);
        }

        // Try placing numbers 1-9
        for (int num = 1; num <= GRID_BOUNDARY; num++) {
            if (isThePlacementCorrect(board, col, row, num)) {
                board[row][col] = num;

                // Recursively try to solve the rest
                if (finalSolve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack if this number doesn't lead to solution
                board[row][col] = 0;
            }
        }

        // No valid number found, backtrack
        return false;
    }

    public static void main(String[] args) {
//        int[][] returnedArray = finalSolve(board,0,0);

        System.out.println("final board is: " +
                finalSolve(SudokuSolver.board,0,0) ) ;
        System.out.println("---------------------------------");
        System.out.println("final board is: " + Arrays.deepToString(board)) ;

        System.out.println(SudokuSolver.isAllowedCol(SudokuSolver.board,0,7));
        System.out.println(SudokuSolver.isAllowedCol(SudokuSolver.board,3,3));

    }
}
