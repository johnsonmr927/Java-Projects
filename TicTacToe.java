import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Create an array with three rows of '_' characters.
    char[][] board = new char[3][3];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = '_';
      }
    }

    // Call the function printBoard();
    printBoard(board);

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X';
      } else {
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      printBoard(board);
      int returnedCount = checkWin(board);
      if (returnedCount == 3) {
        System.out.println("X wins!");
        break;
      } else if (returnedCount == -3) {
        System.out.println("O wins!");
        break;
      }
    }

    /*
     * Loop through turns.
     * 
     * if (X) turn {
     * Call askUser().
     * Populate the board using askUser's return value.
     * } else {
     * Call askUser().
     * Populate the board using askUser's return value. Then, print it.
     * 
     * }
     * 
     * Call the function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */

    scan.close();
  }

  public static void printBoard(char[][] board) {
    System.out.println("\n");
    for (int i = 0; i < board.length; i++) {
      System.out.print("\t");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println("\n\n");
    }
  }

  /**
   * Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  public static int[] askUser(char[][] board) {
    System.out.print("Pick a row and column number: ");
    int[] pick = new int[2];
    int row = scan.nextInt();
    int column = scan.nextInt();

    while (board[row][column] != '_') {
      System.out.print("Spot is occupied. Pick another row and column number: ");
      row = scan.nextInt();
      column = scan.nextInt();
    }
    pick[0] = row;
    pick[1] = column;

    return pick;
  }

  /**
   * Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  public static int checkWin(char[][] board) {
    int count = 0;
    int rows = checkRows(board);
    if (Math.abs(rows) == 3) {
      return rows;
    }

    int colums = checkColumns(board);
    if (Math.abs(colums) == 3) {
      return colums;
    }

    int leftDiagonal = checkLeft(board);
    if (Math.abs(leftDiagonal) == 3) {
      return leftDiagonal;
    }

    int rightDiagonal = checkRight(board);
    if (Math.abs(rightDiagonal) == 3) {
      return rightDiagonal;
    }
  }

  public static int checkRows(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 'X') {
          count += 1;
        } else {
          count -= 1;
        }
      }
      if (count != 3 || count != -3) {
        count += 0;
      }
    }
    return count;
  }

  public static int checkColumns(char[][] board) {
    int count = 0;
    return count;
  }

  public static int checkLeft(char[][] board) {
    int count = 0;
    return count;
  }

  public static int checkRight(char[][] board) {
    int count = 0;
    return count;
  }

}
