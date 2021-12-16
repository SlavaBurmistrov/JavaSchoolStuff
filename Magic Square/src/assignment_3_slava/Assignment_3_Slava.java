/*

      File:  Assignment_3_Slava.java

      Programmer:  Viacheslav Burmistrov

      Purpose: Creates a magic scquare

      I affirm that this program is entirely my own work and none of it is the work of anyone else.

 */
package assignment_3_slava;

import java.util.Scanner;

/**
 * Asks a user to input a size of magic square. If it is Odd and positive, it
 * will create a square. It will loop until the user stops.
 *
 * @author Slava
 */
public class Assignment_3_Slava {

    /**
     * Asks a user to input a size of magic square. If it is Odd and positive,
     * it will create a square. It will loop until the user stops.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int respond = 0; //The respond of the user it stored here
        while (respond == 0) { //while the responds is 0 it will loop.
            System.out.print("Please enter an ODD nuumber: ");
            respond = scnr.nextInt(); //Takes the responds
            if ((respond % 2 != 0) && (respond > 0)) { //It is NOT EVEN and postive
                MagicSquare MS = new MagicSquare(respond); //Creates a square 
                if (MS.GetMagic()) { //Checks if its magic
                    System.out.print(MS.toString()); //Displays it 
                }
                System.out.println("Would you like to do it again?\n 1 for yes"
                        + " 2 for no.");
                int yesNo = scnr.nextInt(); //Does the user want to do it again
                if (yesNo == 1) {
                    respond = 0;
                }
            } else { //Error when even number is inputted
                System.out.println("ODD numbers only!");
                respond = 0;
            }
        }
    }
}
