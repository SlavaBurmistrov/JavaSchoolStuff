/*

      File:  DumbComputer.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the AI of a not so smart computer. Simply returns 
      a random number to take from the pile.

      I affirm that this program is entirely my own work and none 
        of it is the work of anyone else.

 */
package assignment_4_slava;

import java.util.Random;

/**
 * This is where methods for Below Average AI is stored. It uses "Play"
 * interface, so it shares methods with other classes that use that interface.
 * This AI generates a random value thats half the size of the pile and returns
 * it.
 *
 * @author Slava
 */
public class DumbComputer implements Play {

    private int marbles, marbLeft, randNum;//Ints used for calculations of the
    //actions. 
    private String name; //Used to store the name of the AI
    Random randGen = new Random();//To generate random ints

    /**
     * Constructor creates a name for the AI
     */
    public DumbComputer() {
        name = "Marvin";
    }

    /**
     * In this method, AI returns a random value to subtract from the pile.
     *
     * @param x takes in the current pile
     * @return marbles to take out
     */
    @Override
    public int Move(int x) {
        marbLeft = x;
        marbles = 0;
        if (marbLeft > 1) {
            randNum = randGen.nextInt(marbLeft / 2) + 1;// Generates random 
                                         //value that is half of the pile or less
            //System.out.println(randNum);
            marbles = randNum;
        }
        return marbles;
    }

    /**
     * Simply returns a name
     *
     * @return name of AI
     */
    @Override
    public String Name() {
        return name;
    }
}
