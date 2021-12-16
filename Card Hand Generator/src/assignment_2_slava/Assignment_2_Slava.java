/*

      File:  Assignment_2_Slava.java

      Programmer:  Viacheslav (Slava) Burmistrov

      Purpose: This is a main class, it builds the main program and display the output
      inside an .txt file. It starts off by asking a user what is the size of the 
      hand they want.

      I affirm that this program is entirely my own work and none of it is the work of anyone else.

 */
package assignment_2_slava;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is a main class, it builds the main program and display the output
 * inside an .txt file. It starts off by asking a user what is the size of the
 * hand they want.
 *
 */
public class Assignment_2_Slava {

    /**
     * This is where the magic is done. Simply asks user what is the size of
     * deck they need. This will be in a 'While' loop until the decide to get
     * off of the wild ride by typing 0 when asked.
     *
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        int handSize; //Stores the hand size of the user
        int reply; //Stores the reply of the user
        boolean giveCard = true; // for the while loop
        Scanner scnr = new Scanner(System.in);

        while (giveCard) { //Will continue until the user gets bored
            System.out.print("Hello, please enter the size of the hand"
                    + " you need: ");
            handSize = scnr.nextInt();
            String fileName = "output.txt"; //Creates a file to store stuff
            PrintWriter writer = new PrintWriter(fileName);
            Hand hand = new Hand(handSize); //Creates hand based on the user's wanted size
            writer.println(hand.ShowHand()); //Puts the hand inside the file
            writer.close();
            //Asks the user if they want more
            System.out.print("Would you like a new hand? 1 for yes, 0 for no: ");
            reply = scnr.nextInt();
            if (reply == 0) {
                System.out.println("Thank you for playing.");
                giveCard = false;
            } else {
                System.out.println("I will take that as a YES!");
            }
        }
    }
}
