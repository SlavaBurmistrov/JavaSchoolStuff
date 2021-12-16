/*

      File:  Assignment_4_Slava.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is where the whole program is running. Loops until the 
      player decides to end the game.

      I affirm that this program is entirely my own work and none of it is 
      the work of anyone else.

 */
package assignment_4_slava;

import java.util.Scanner;

/**
 * This is where the magic happens. It asks the user that kind of a game they
 * want to play. Then it calls all of the methods until the game is over. After
 * it asks if they want to play again. If yes, it loops, if no, it ends.
 *
 * @author Slava
 */
public class Assignment_4_Slava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean play = true; //used to loop the game
        boolean check = true; //Used to loop if the user wants to plat again
        int gameMode; //stores the game type
        int game; //Stores the answer to play again
        while (play) {
            play = true;
            check = true;
            gameMode = 0;
            game = 0;
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please enter how you want to play?");
            System.out.println("(1) vs. Smart AI");
            System.out.println("(2) vs. Easy AI");
            System.out.println("(3) AI vs. AI");
            System.out.print("Please enter here: ");
            gameMode = scnr.nextInt();
            Nim nim = new Nim(); //Creates the object of the game
            System.out.println("Only 1 marble left.\nThe winner is " + nim.Play(gameMode));
            //^Returns the winner of the game.
            while (check) { //Checks if the user wants to play again
                System.out.print("Want to play again? \n (1)Yes | (2) No");
                game = scnr.nextInt();
                if (game == 2) {
                    check = false;
                    play = false;
                } else if (game == 1) {
                    check = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

}
