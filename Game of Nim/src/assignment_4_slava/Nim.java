/*

      File:  Nim.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is where the game of nim is played. It asks the user for 
      the type of game to play. Then, it plays it out. Returns the winner 
      as a string.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_4_slava;

/**
 * This is where the game is played. Nim takes a pile object, and two classes of
 * players, AI or Human. It polymorthically uses their methods to play the game
 * and returns the name of the winner. Nim class does not have a constructor
 * since its not needed.
 *
 * @author Slava
 */
public class Nim {

    private int marbTaken;//Stores the taken marbles
    Pile pile = new Pile(); // Calls the pile object
    private Boolean game = true; //used to loop the game
    private String winner = ""; //Stores the winner of the game
    private Play players[] = new Play[2]; //Array for the number of players

    /**
     * The play method is where the game is played. It takes two elements of the
     * players array and clashes them together in the game of Nim. Only one
     * method is used per class, so Move() and Name() is used polymorthycally.
     * At the end it returns the name of the winner as a string.
     *
     * @param who takes in the value of what kind of game its going to be
     * @return string of the winner's name
     */
    public String Play(int who) {

        switch (who) {
            case 1: //vs. Smart AI
                players[0] = new Human();
                players[1] = new SmartComputer();
                break;
            case 2: //vs. Easy AI
                players[0] = new Human();
                players[1] = new DumbComputer();
                break;
            case 3: // AI vs AI, greg always wins tho
                players[0] = new SmartComputer();
                players[1] = new DumbComputer();
                break;
        }
        while (game) { //Tha game will loop until only one marble left 
            for (int x = 0; x < 2; x++) { //This loop switches between 
                                          //two players.
                if (pile.GetPile() < 2) { //Imideatly exit the loop
                    game = false;
                    break;
                }
                System.out.println("Size of the pile: " + pile.GetPile());
                marbTaken = players[x].Move(pile.GetPile()); //Move method
                pile.removePile(marbTaken); //Takes marbles from pile
                System.out.println(players[x].Name() + " takes out "
                        + marbTaken + " marbles.");
                winner = players[x].Name(); //Stores the winner name
            }
        }

        return winner;
    }

}
