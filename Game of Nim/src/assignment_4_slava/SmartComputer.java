/*

      File:  SmartComputer.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the AI for the smart computer that is impossible to beat.

      I affirm that this program is entirely my own work and none
      of it is the work of anyone else.

 */
package assignment_4_slava;

import java.util.Random;

/**
 * This is a very complicated class that is almost impossible to beat at Nim. It
 * removes exactly enough marbles to leave the pile to be (2^n - 1). Therefore,
 * it generates a random number until that number suits the condition to remove
 * from the pile. It checks each random number until the right one is found.
 *
 * @author Slava
 */
public class SmartComputer implements Play {

    private int marbles, marbLeft, randNum, marbSmart;//Ints used for 
    //calculations of the actions. 
    private String name;//Stores the name of the AI
    private boolean test; //Used to loop a method
    Random randGen = new Random();//for random numbers

    /**
     * Constructor names the AI
     */
    public SmartComputer() {
        name = "Greg";
    }

    /**
     * The move method for this AI generates a number until that number fits the
     * criteria for use. It has to remove exactly enough marbles to leave the
     * pile to be (2^n - 1). It uses a separate method to check.
     *
     * @param x takes in the size of the pile
     * @return marbles to take out
     */
    @Override
    public int Move(int x) {
        marbLeft = x;
        marbles = 0;
        marbSmart = marbLeft;
        test = true;
        if (marbLeft > 1) {
            while (test) { //This will run until the correct number is made.
                marbSmart = marbLeft;
                randNum = randGen.nextInt(marbLeft / 2) + 1;
                marbSmart = marbSmart - randNum;
                // System.out.println(randNum);
                if (CheckMarble(marbSmart)) {
                    break;
                }
            }
            marbles = randNum;
        }
        return marbles;
    }

    /**
     * This method check if the random number fits the criteria.
     * It adds 1 to the number, then it checks if it has a remainder of 1.
     * If not, then it divides it by 2 until 0 is reached. Only after that it
     * returns true.
     * 
     * @param y the random number to check 
     * @return the random met the condition or not
     */
    private boolean CheckMarble(int y) {
        y = y + 1;
        while (y != 1) {
            if (y % 2 != 0) {
                return false;
            }
            y = y / 2;
        }
        return true;
    }
    /**
     * Returns the name
     * 
     * @return the name of AI
     */
    @Override
    public String Name() {
        return name;
    }
}
