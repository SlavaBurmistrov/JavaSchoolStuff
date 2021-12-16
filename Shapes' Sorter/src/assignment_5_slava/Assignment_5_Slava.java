/*

      File:  Assignment_5_.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is where all of the out put of the program happens. 
      The driver class initializes the Array of shapes objects and then sorts
      them many different ways. Also outputs their values.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

import java.util.Arrays;

/**
 * The driver class initializes the Array of shapes objects and then sorts them
 * many different ways. Also outputs their values. It has 3 loops to display the
 * array of shapes.
 *
 * @author Slava
 */
public class Assignment_5_Slava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shape3D Shapes[] = new Shape3D[4]; //Array of Shapes
        SortByOrigin SortDist = new SortByOrigin(); //Used to sort by distance
        Shapes[0] = new Sphere(2, 5, 8, 14); //Object of Sphere
        Shapes[1] = new Parallelepiped(7, 16, 9, 19, 9, 13); //Object of ShoeBox
        Shapes[2] = new Cone(-5, 4, -1, 15, 11); //Object of Cone
        Shapes[3] = new Cylinder(-3, -7, 5, 12, 14); //Object of Cylinder

        for (int x = 0; x < 4; x++) { //First prints out the values of shapes
            Shapes[x].Area();         //Calculates the Area
            Shapes[x].Volume();       //Calculates the Volume
            System.out.println(Shapes[x].toString()
                    + "\nArea: " + Shapes[x].Area()); //Displays Area and Info
            System.out.println("-----------------------------------------");
        }

        System.out.println("______________________________________________");
        Arrays.sort(Shapes);//Sorts the Shapes by Volume
        for (int x = 0; x < 4; x++) { //Shows the volumes of shapes
            System.out.println(Shapes[x].GetName());
            System.out.println("Volume: " + Shapes[x].Volume());
            System.out.println("-----------------------------------------");
        }

        System.out.println("_____________________________________________");
        Arrays.sort(Shapes, SortDist); //Sorts by distance
        for (int x = 0; x < 4; x++) {
            System.out.println(Shapes[x].GetName()); //Shows the distance
            System.out.println("Distance: " + Shapes[x].Distance());
            System.out.println("-----------------------------------------");
        }

    }

}
