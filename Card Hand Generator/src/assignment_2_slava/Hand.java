/*

      File:  Deck.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is where the hand of cards is created. As the hand fills with cards 
      it is automatically sorted into the correct order. Then it is parsed into a String,
      ready to be displayed.

      I affirm that this program is entirely my own work and none of it is the work of anyone else.

 */
package assignment_2_slava;

/**
 * This is where the hand of cards is created. As the hand fills with cards it
 * is automatically sorted into the correct order. Then it is parsed into a
 * String, ready to be displayed.
 *
 */
public class Hand {

    Deck deck = new Deck();
    Card[] HandArray;
    private String hand; //Will contain the ARHand when displayed
    private final int HAND_SIZE;//Stores the size of the hand
    private int currentSize; //Keeps track of array size

    //-----Varibles for Shuffling------
    int tempRank1;
    int tempRank2;
    Card temp1;
    Card temp2;
    int tempSuit1;
    int tempSuit2;
    //----------------------------------

    /**
     * Builds a hand with a desired number of cards
     *
     * @param x the size of the hand
     */
    public Hand(int x) {
        HAND_SIZE = x;
        HandArray = new Card[HAND_SIZE];
        currentSize = 0;
        hand = "";
    }

    /**
     * Calls a card from the top of the deck object and puts it in the hand. The
     * card is put in the correct position in the hand as it is taken. Going
     * from the smallest to largest value, as well as from spades to diamonds.
     */
    public void FillHand() {
        for (int i = 0; i < HAND_SIZE; i++) {
            HandArray[i] = deck.GetTopCard(i); //Puts the card in the hand.
            for (int j = 0; j < currentSize; j++) {
                temp1 = HandArray[i]; //Takes the new card
                temp2 = HandArray[j]; //Takes the existing card
                tempRank1 = temp1.GetRank(); //The rank of card 1
                tempRank2 = temp2.GetRank(); //The rank of card 2
                tempSuit1 = temp1.GetSuitInt(); //The suit of card 1
                tempSuit2 = temp2.GetSuitInt(); //The suit of card 2
                if (tempSuit1 < tempSuit2) { //First compares the suits
                    HandArray[j] = temp1;
                    HandArray[i] = temp2;
                } else if (tempSuit1 == tempSuit2) { //If they are equal
                    if (tempRank1 < tempRank2) { //Compare the ranks
                        HandArray[j] = temp1;
                        HandArray[i] = temp2;
                    }
                }
            }
            currentSize++; //keeps track of the array
        }
    }

    /**
     * Shuffles the deck of cards. Then filles the hand with the cards. Turns
     * the hand into a string ready for use.
     *
     * @return the hand string
     */
    public String ShowHand() {
        deck.Shuffle(); //Shuffle
        FillHand(); //Fill
        for (int i = 0; i < HAND_SIZE; i++) {
            hand = hand + " " + HandArray[i].toString();
        }
        return hand;

    }

}
