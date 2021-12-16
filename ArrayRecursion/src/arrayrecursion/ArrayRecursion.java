/*

      File:  ArrayRecursion.java (Assignment_7)

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the ArrayRecursion class which also has the main method.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package arrayrecursion;

/*  File: ArrayRecursion.java
 *
 *  Programmer: Viacheslav Burmistrov
 *  
 */
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class that performs some simple array operations recursively
 *
 * @author Greg / Slava
 */
public class ArrayRecursion {
    // instance var's

    private int[] list;       // array of ints
    private int size;         // number of elements

    /**
     * Create an ArrayRecursion object. Creates an array with between 10 and 15
     * elements, and fills it with random positive 2-digit ints
     */
    public ArrayRecursion() {
        Random r = new Random();
        size = r.nextInt(6) + 10;
        list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /**
     * Return the list as a string
     *
     * @return a string containing all ints stored in list
     */
    public String toString() {
        String out = "";
        for (int i = 0; i < size; i++) {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Returns the index of the largest value in the array.
     *
     * @return the index of the largest value in the array
     */
    public int getIndexOfLargest() {
        return recursiveGetIndexOfLargest(list, size);
    }

    /**
     * recursive "helper" method to return index of largest value called by
     * public method getIndexOfLargest()
     *
     * @param list gets the array
     * @param count keeps track of the position
     * @return the index with the largest value
     */
    private int recursiveGetIndexOfLargest(int[] list, int count) {
        if (count < 1) { //Base case
            return 0;
        } else if (list[count - 1]
                > list[recursiveGetIndexOfLargest(list, count - 1)]) {
            return count - 1; //return the index of the current large value
        } else {
            return recursiveGetIndexOfLargest(list, count - 1); //recusrion
        }

    }

    /**
     * Sort the array in descending order using the selection sort
     */
    public void sort() {
        recursiveSort(list, size);
    }

    /**
     * recursive "helper" method to sort the array called by public method
     * sort()
     *
     * @param list the array
     * @param count keeps track of the recursion.
     */
    private void recursiveSort(int[] list, int count) {
        if (count < 1) { //base case
            return;
        }
        int maxIndex = recursiveGetIndexOfLargest(list, count); //large index
        int maxValue = list[maxIndex]; //large value
        int currValue = list[count - 1]; //the value being swapped
        list[maxIndex] = currValue; //swap
        list[count - 1] = maxValue; //swap
        recursiveSort(list, count - 1); //recusrion 

    }

    /**
     * Indicates whether a given int is on the list
     *
     * @param target the int to search for
     * @return true if target is on the list, false if not
     */
    public boolean contains(int target) {
        return recursiveContains(list, size, target);
    }

    /**
     * recursive "helper" method to search the array called by public method
     * contains()
     *
     * @param list the array
     * @param count keeps track of the recursion
     * @param target the value being searched
     * @return true/false depending if the value is in the array
     */
    private boolean recursiveContains(int[] list, int count, int target) {
        if (count < 1) { //base case
            return false;
        } else if (target == list[count - 1]) { //if the targest mathes
            return true; //return true
        }
        return recursiveContains(list, count - 1, target); //recursion
    }

    public static void main(String[] args) {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);

        System.out.println("Largest value is at index: "
                + list.getIndexOfLargest());
        list.sort();
        System.out.println("\nSorted:    " + list);

        String target = JOptionPane.showInputDialog("Number to search for?");
        int searchee = Integer.parseInt(target);

        if (list.contains(searchee)) {
            System.out.println(searchee + " is on the list");
        } else {
            System.out.println(searchee + " is not on the list");
        }
    }

}
