/*

      File:  Play.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the interface for the classes of players.

      I affirm that this program is entirely my own work and none of it 
      is the work of anyone else.

 */
package assignment_4_slava;

/**
 * This is the interface to be used by players of the nim. It has two methods:
 * Move() and Name()
 *
 * @author Slava
 */
public interface Play {

    int Move(int x);

    String Name();
}
