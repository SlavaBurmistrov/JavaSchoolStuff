/*

      File:  MagicSquare.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is where the hand of cards is created. As the hand fills with cards 
      it is automatically sorted into the correct order. Then it is parsed into a String,
      ready to be displayed.

      I affirm that this program is entirely my own work and none of it is the work of anyone else.

 */
package assignment_3_slava;

/**
 * This is where the MagicSquare is generated based on the user input. When the
 * object is called, it generates a 2D array that is equal on both sides. After
 * it fills the square using a special algorithm to make it a magic square where
 * all sides are equal. It has a method that checks if its magic and a method
 * that displays it as a string.
 *
 * @author Slava
 */
public class MagicSquare {

    private int SIZE; //Side of the array
    private int[][] magicSquare; //The 2D array
    private int curRow, curCol; //Current postion
    private int preRow, preCol; //Previous position
    private String box; //String for the square 
    private int[] check; //Array used to check if the quare is magic
    private Boolean magic; //Returns true if magic

    /**
     * Initializes a magic square with a parsed variable. Fills the square with
     * FillMethod.
     *
     * @param x size of the square
     */
    public MagicSquare(int x) {
        box = ""; //Makes it empty 
        SIZE = x; //Initializes the size
        magicSquare = new int[SIZE][SIZE]; //Makes the 2D array
        FillSquare(); //fills the 2D array
        //Magic();
    }

    /**
     * This is a method that fills the square with a special method. it places 1
     * in the last row and middle column. After it follows the algorithm: a.
     * Place # one row below and one column to the right. b. If (a) no row and
     * no column. Place # directly above previous # c. if (a) no row. Place # in
     * first row, one column right. d. if (a) no column. Place # in the first
     * column, one row down. e. if (a) is taken. Place # directly above previous
     * #.
     *
     */
    private void FillSquare() {
        curRow = SIZE - 1;
        curCol = SIZE / 2;
        magicSquare[curRow][curCol] = 1; //Places value 1 onto position
        for (int i = 2; i <= SIZE * SIZE; i++) {
            preRow = curRow; //Saves the previous location
            preCol = curCol;
            curRow++; //Moves it the left
            curCol++; //Moves it one down
            if ((curRow > (SIZE - 1)) & (curCol > (SIZE - 1))) { //case B
                curRow = preRow - 1;
                curCol = preCol;
                magicSquare[curRow][curCol] = i;
            } else if (curRow > (SIZE - 1)) { //case C
                curRow = 0;
                curCol = preCol + 1;
                magicSquare[curRow][curCol] = i;
            } else if (curCol > (SIZE - 1)) { //case D
                curRow = preRow + 1;
                curCol = 0;
                magicSquare[curRow][curCol] = i;
            } else if (magicSquare[curRow][curCol] != 0) { //Case E
                curRow = preRow - 1;
                curCol = preCol;
                magicSquare[curRow][curCol] = i;
            } else {
                magicSquare[curRow][curCol] = i; //case A
            }
        }
    }

    /**
     * Turns the 2D array into a string to display.
     *
     * @return the string that stores the 2D array.
     */
    public String toString() {
        for (int i = 0; i < SIZE; i++) {
            box = box + "\n";
            for (int j = 0; j < SIZE; j++) {
                box = box + " " + Integer.toString(magicSquare[i][j]);
            }
        }
        box = box + "\n";
        return box;
    }

    /**
     * This method checks if all of the sides of the 2D square are equal to each
     * other. Columns, rows and diagonally. If they are all equal its magic.
     * Stores each side into check array.
     *
     * @return true if magic, false if not
     */
    private Boolean Magic() {
        check = new int[SIZE + SIZE + 2]; //This is where the sum of all sides will be stored
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                check[i] = check[i] + magicSquare[i][j];//rows
                check[SIZE + i] = check[SIZE + i] + magicSquare[j][i];//columns
            }
        }
        for (int h = 0; h < SIZE; h++) {
            check[SIZE + SIZE] = check[SIZE + SIZE] + magicSquare[h][h];//Diagonal 1
            check[SIZE + SIZE + 1] = check[SIZE + SIZE + 1] + magicSquare[(SIZE - 1) - h][h];//Diagonal 2
        }
        for (int k = 0; k < check.length - 1; k++) {
            if (check[k] == check[k + 1]) { //Compares each array element with its next.
                magic = true;
            } else {
                magic = false;
            }
        }
        if (magic) {
            System.out.println("ITS MAGIC!");
        }
        return magic;
    }

    /**
     * Gets the magic method
     *
     * @return magic check method
     */
    public Boolean GetMagic() {
        return Magic();
    }
}
