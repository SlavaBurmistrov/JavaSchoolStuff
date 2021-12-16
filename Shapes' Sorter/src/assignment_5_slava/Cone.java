/*

      File:  Cone.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the cone class. It has methods exculsive to Cone 
      and outputs values exculsive to it.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

/**
 * This class has methods for calculating the values of Cone. Its parent class
 * is Shape3D.
 *
 * @author Slave
 */
public class Cone extends Shape3D {

    private int hight, radius; //Stores the values
    private double area, volume, slant; //Stores the values
    private String info, name; //Stores the info

    /**
     * The constructor of Cone, initializes all of the value of the center
     * point, as well as the radius and hight of the shape and the name.
     *
     * @param x value of a point
     * @param y value of a point
     * @param z value of a point
     * @param h value of hight
     * @param r value of radius
     */
    public Cone(int x, int y, int z, int h, int r) {
        super(x, y, z);
        hight = h;
        radius = r;
        name = "Cone";
    }

    /**
     * Overwrites the Area method of Shape3D class to return the area of the
     * shape.
     *
     * @return area of the Cone
     */
    @Override
    public double Area() {
        //Calculates Area and slant
        slant = Math.sqrt(radius * radius + hight * hight);
        area = Math.PI * radius * (radius + slant);
        return area;
    }

    /**
     * Overwrites the method to output, name, center, hight and radius.
     *
     * @return the string that stores all that info
     */
    @Override
    public String toString() {
        info = name
                + "\nCoordinates of the center: " + super.toString()
                + "\nRadius: " + radius
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
     * @return volume of the Cone
     */
    @Override
    public double Volume() {
        //Calulates the volume
        volume = (22 * radius * radius * hight) / (3 * 7);
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
