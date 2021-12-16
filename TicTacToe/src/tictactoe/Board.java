/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Slava
 */
public class Board {

    private int row, col;
    private char[][] board = new char[3][3];
    private char turn = 'X';
    private String boardGame;
    private boolean playing = false;
    private boolean checkRow = false;
    private boolean checkCol = false;
    Scanner scnr = new Scanner(System.in);
    Random randGen = new Random();
    private int moveCount = 8;

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    public void PrintBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");

                }
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println("");
    }

    public void Play() {
        this.clearBoard();
        playing = true;
        while (playing) {
            PrintBoard();
            boolean playerCheck = true;
            while (playerCheck) {
                if (turn == 'X') {
                    checkRow = false;
                    checkCol = false;
                    while (checkRow != true) {
                        System.out.print("Input the row number: ");
                        row = scnr.nextInt() - 1;
                        if (row == 0 || row == 1 || row == 2) {
                            checkRow = true;
                        } else {
                            col = 0;
                        }
                    }
                    while (checkCol != true) {
                        System.out.print("Input the col number: ");
                        col = scnr.nextInt() - 1;
                        if (col == 0 || col == 1 || col == 2) {
                            checkCol = true;
                        } else {
                            col = 0;
                        }
                    }
                    if (board[row][col] != turn && board[row][col] != 'O') {
                        playerCheck = false;
                        board[row][col] = turn;
                        moveCount--;
                        turn = 'O';
                    } else {
                        System.out.println("That space is taken. Try again!");
                    }
                } else {
                    turn = 'X';
                }
            }
            if (turn == 'O') {
                AIMove();
               // turn = 'X';
            }
            if (GameOver(row, col)) {
                PrintBoard();
                System.out.println("Player " + turn + " wins!");
                moveCount = 8;
                System.out.print("Play again? 1 for Yes, 0 for No: ");
                int input = scnr.nextInt();
                if (input == 1) {
                    this.clearBoard();
                } else {
                    playing = false;
                }
            }
            if (moveCount <= 0) {
                PrintBoard();
                System.out.println("Its a Tie");
                moveCount = 8;
                System.out.print("Play again? 1 for Yes, 0 for No: ");
                int input = scnr.nextInt();
                if (input == 1) {
                    this.clearBoard();

                } else {
                    playing = false;
                }
            }
        }
    }

    public void AIMove() {
        row = 0;
        col = 0;
        boolean AICheck = true;
        while (AICheck) {
            row = randGen.nextInt(3);
            col = randGen.nextInt(3);
            if (board[row][col] != turn && board[row][col] != 'X') {
                AICheck = false;
            }
        }

        board[row][col] = turn;
        moveCount--;
    }

    public boolean GameOver(int x, int y) {
        //Check first row
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '_') {
            return true;
        }
        //Check row 2
        if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != '_') {
            return true;
        }
        //Check row 3
        if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != '_') {
            return true;
        }
        //Check first col
        if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != '_') {
            return true;
        }
        //Check col 2
        if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '_') {
            return true;
        }
        //Check col 3
        if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '_') {
            return true;
        }
        //Check Diagonal Victory
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
                && board[1][1] != '_') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
                && board[1][1] != '_') {
            return true;
        }
        return false;
    }

    public void GameAgain() {

    }
}
