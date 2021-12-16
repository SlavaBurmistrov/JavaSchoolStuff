/*

      File:  SortByOrigin.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is a SortByOrigin class that only exists to sort the shapes
      by distances.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

import java.util.Comparator;

/**
 * This class only exists to compare distances the two objects. It utilizes
 * comparator method for that. This class will be used in Arrays.sort.
 *
 * @author Slava
 */
public class SortByOrigin implements Comparator {

    /**
     * This is the only method of the class. It compares to object's distances
     * and returns int value 1,-1,0 depending on the comparison.
     *
     * @param shapeOne Object of the first shape
     * @param shapeTwo Object of the second shape
     * @return int depending on the comparison
     */
    @Override
    public int compare(Object shapeOne, Object shapeTwo) {
        Shape3D First = (Shape3D) shapeOne;
        Shape3D Second = (Shape3D) shapeTwo;
        if (First.Distance() < Second.Distance()) {
            return -1;
        } else if (First.Distance() > Second.Distance()) {
            return 1;
        } else // they are equal
        {
            return 0;
        }
    }

}
