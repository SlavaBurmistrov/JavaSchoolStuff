/*

      File:  Assignment_6_Slava.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the main method of the project, it acts as the reader of 
      the file and executor if the commands for the list.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_6_slava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is where the magic is done. The file from the project is read and it
 * takes the commands from the files it and executes them.
 *
 * @author Slava
 */
public class Assignment_6_Slava {

    /**
     * The main class does the main job, takes the file, reads commands, and
     * executes them.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        TheList LL = new TheList(); //Object for the list
        String command = ""; //string to store commands
        int x; //used for first value
        int y; //used for second value
        Scanner fileScnr = new Scanner(new File("list-ops.txt")); //File reader
        while (fileScnr.hasNextLine()) { //Loops until the file has no lines
            command = fileScnr.next(); //Gets the command
            System.out.print(command + " "); //prints it
            switch (command) { //Checks what command it is
                case "APPEND": { //Command is append
                    x = fileScnr.nextInt(); //Get the int value
                    System.out.print("(" + x + "): ");
                    LL.APPEND(x); //Parses it
                    System.out.println(LL);
                    break;
                }
                case "ADD": { //Command is add
                    x = fileScnr.nextInt();//Get the first value
                    y = fileScnr.nextInt();//Get the second value
                    System.out.print("(" + x + ", " + y + "): ");
                    LL.ADD(x, y); //Parse them 
                    System.out.println(LL);
                    break;
                }
                case "DELETE": { //Command to delete
                    x = fileScnr.nextInt(); //Get the value
                    System.out.print("(" + x + "): ");
                    LL.DELETE(x); //Parse it
                    System.out.println(LL);
                    break;
                }
                case "REVERSE": { //Command to reverse
                    LL.REVERSE();
                    System.out.println(LL);
                    break;
                }

                case "CLEAR": { //Command to clear
                    LL.CLEAR();
                    System.out.println(LL);
                    break;
                }
                case "SWAP": { //Command to swap
                    x = fileScnr.nextInt();
                    y = fileScnr.nextInt();
                    System.out.print("(" + x + ", " + y + "): ");
                    LL.SWAP(x, y);
                    System.out.println(LL);
                    break;
                }
            }

        }

    }

}
