/*

      File:  Human.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the player class that user can control. Simply returns
      the input of the player.

      I affirm that this program is entirely my own work and none of it is
      the work of anyone else.

 */
package assignment_4_slava;

import java.util.Scanner;

/**
 *
 * This is where the Human methods are stored. This class used "Play" interface
 * so it shares it methods with other classes that use the interface. This class
 * simply takes two inputs from the user: Name and number of marbles to take.
 */
public class Human implements Play {

    private int marbles, marbLeft;//used for calculations of actions
    private String name;//used to store a name
    Scanner scnr = new Scanner(System.in);

    /**
     * In the constructor, the name is initialized.
     */
    public Human() {
        System.out.print("What is your name?: ");
        name = scnr.next();
    }

    /**
     * Here is where the move is made. The method takes in a value, checks if
     * its half or less than the pile, then it returns it.
     *
     * @param x stores the current amount of marbles in the pile
     * @return number of marbles
     */
    @Override
    public int Move(int x) {
        marbLeft = x; //The current size of the pile 
        marbles = 0;
        System.out.print("How many marbles do you want to take?: ");
        marbles = scnr.nextInt(); //Takes input
        while (marbles > (marbLeft / 2)) { //Loops until the correct value is
            //inputed.
            System.out.println("Cannot take more than half.");
            System.out.print("How many marbles do you want to take?: ");
            marbles = scnr.nextInt();
        }

        return marbles;
    }

    /**
     * Simply returns the name
     *
     * @return name of the user
     */
    @Override
    public String Name() {
        return name;
    }
}
