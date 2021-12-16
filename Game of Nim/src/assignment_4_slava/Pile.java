/*

      File:  Pile.java

      Programmer:  Viacheslav Burmistrov

      Purpose: Acts as a pile of marbles, where it is generated and removed 
      from.

      I affirm that this program is entirely my own work and none of it is the
      work of anyone else.

 */
package assignment_4_slava;

import java.util.Random;

/**
 * Pretty simple method that just keeps track of the pile It generates random
 * pile and has a method to take from the pile.
 *
 * @author Slava
 */
public class Pile {

    private int pile;//Stores the size of the pile
    Random randGen = new Random();//to generate the random int

    /**
     * The constructor creates a random pile
     */
    public Pile() {
        pile = randGen.nextInt(100 - 10 + 1) + 10;
    }

    /**
     * Returns the current size of the pile
     *
     * @return
     */
    public int GetPile() {
        return pile;
    }

    /**
     * Takes a number from the pile, however it cannot be 0
     *
     * @param x takes in a number to subtract
     */
    public void removePile(int x) {
        if (x > 0) {
            pile = pile - x;
        }
    }
}
