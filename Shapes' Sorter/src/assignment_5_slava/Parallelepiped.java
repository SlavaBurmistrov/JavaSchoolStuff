/*

      File:  Parallelepiped.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the Parallelepiped class. It has methods exculsive to 
      Parallelepiped and outputs values exculsive to it.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

/**
 * This class has methods for calculating the values of Parallelepiped. Its
 * parent class is Shape3D.
 *
 * @author Slava
 */
public class Parallelepiped extends Shape3D {

    private int length, width, hight; //Stores the values for the "shoebox"
    private String info, name; //Stores the info about the class
    private double area, volume; //Sotes the area and volume

    /**
     * The constructor of Parallelepiped, initializes all of the value of the
     * center point, as well as the length, width and hight of the shape and the
     * name.
     *
     * @param x value of a point
     * @param y value of a point
     * @param z value of a point
     * @param l value of length
     * @param w value of width
     * @param h value of hight
     */
    public Parallelepiped(int x, int y, int z, int l, int w, int h) {
        super(x, y, z);
        length = l;
        width = w;
        hight = h;
        name = "Parallelepiped";
    }

    /**
     * Overwrites the Area method of Shape3D class to return the area of the
     * shape.
     *
     * @return area of the parallelepiped
     */
    @Override
    public double Area() {
        //Calculates Area
        area = 2 * ((length * width) + (length * hight) + (width * hight));
        return area;
    }

    /**
     * Overwrites the method to output, name, center, length, width and hight.
     *
     * @return the string that stores all that info
     */
    @Override
    public String toString() {
        info = name
                + "\nCoordinates of the center: " + super.toString()
                + "\nLength: " + length
                + "\nWidth: " + width
                + "\nHight: " + hight;
        return info;
    }

    /**
     * Overwrites the compareTo method of the Comparable interface so that it
     * can be used to compare the volumes of the shapes.
     *
     * @param otherObject The Object of the shape that is being compared.
     * @return 1, -1 or 0 depending if volume is smaller or bigger.
     */
    @Override
    public int compareTo(Object otherObject) {
        Shape3D other = (Shape3D) otherObject;
        if (this.Volume() > other.Volume()) { //This volume is greater
            return -1;
        } else if (this.Volume() < other.Volume()) { //This volume is less
            return 1;
        } else // they are equal
        {
            return 0;
        }

    }

    /**
     * Overwrites the Volume method of Shape3D class to return the area of the
     * shape.
     *
     * @return volume of the parallelepiped
     */
    @Override
    public double Volume() {
        //Calulates the volume
        volume = length * width * hight;
        return volume;
    }

    /**
     * Overwrites the GetName method of Shape3D class to out put the name of the
     * shape.
     *
     * @return name of the class
     */
    @Override
    public String GetName() {
        return name;
    }
}
