/*

      File:  Card.java

      Programmer:  Viacheslav Burmistrov

      Purpose:  This is a Card blueprint. It acts as an idetified card, until 
      two values are passed into it that generates a card. It also has a ToString
      method that will return that card when called.

      I affirm that this program is entirely my own work and none of it is the work of anyone else.

 */
package assignment_2_slava;

import java.util.Random;

/**
 * This is a Card blueprint. It acts as an unidetified card, until two values
 * are passed into it that generates a card. It also has a ToString method that
 * will return that card when called.
 *
 */
public class Card {

    Random ranGen = new Random();
    private final int rank; //Stores the rank of the card
    private final int suitInt; //Store the numerical value of the suit
    private final String suit; //Stores the suit of the card
    private final String[] suitList = new String[4]; //Array to store the suits
    private String card; //this is where the built card will store

    /**
     * Creates a card when two values are passed to it. Suit takes in numerical
     * value, and then it is taken from the array of suits.
     *
     * @param r Rank of the card
     * @param s Numerical value of the suit.
     */
    public Card(int r, int s) {
        rank = r; //Initial the rank
        suitInt = s; ///Initail the suit 
        suitList[0] = "\u2660"; //Spades
        suitList[1] = "\u2663"; //Crosses
        suitList[2] = "\u2665"; //Hearts
        suitList[3] = "\u2666"; //Dimonds
        suit = suitList[suitInt];

    }

    /**
     * Creates a string of a card. if the rank value is higher than 10, it
     * checks to see to what face it needs to be converted to display.
     *
     * @return This method returns a string represintation of the card object.
     */
    public String toString() {
        char face; //Stores ranks like J,Q,K,A
        switch (rank) {
            case 11: //if the rank 11 its Jack
                face = 'J';
                card = face + suit;
                return card;
            case 12: //if the rank 12 its Queen
                face = 'Q';
                card = face + suit;
                return card;
            case 13: //if the rank 13 its King
                face = 'K';
                card = face + suit;
                return card;
            case 14: //if the rank 14 its Ace
                face = 'A';
                card = face + suit;
                return card;
            default: //else just return the card
                card = rank + suit;
                return card;
        }
    }

    /**
     * Returns just the rank of the card
     *
     * @return rank of the card
     */
    public int GetRank() {
        return rank;
    }

    /**
     * Returns just the suit of the card
     *
     * @return suit of the card
     */
    public String GetSuit() {
        return suit;
    }

    /**
     * Returns the numerical representaion of the suit.
     *
     * @return the number of the suit
     */
    public int GetSuitInt() {
        return suitInt;
    }

}
